package me.ele.shop.sdk.interceptor;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import me.ele.shop.sdk.Config;
import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.exception.BusinessException;
import me.ele.shop.sdk.interfaces.exception.ServerErrorException;
import me.ele.shop.sdk.interfaces.exception.ServiceException;
import me.ele.shop.sdk.interfaces.exception.UnauthorizedException;
import me.ele.shop.sdk.protocol.ErrorPayload;
import me.ele.shop.sdk.protocol.ResponsePayload;
import me.ele.shop.sdk.reflect.VInvoke;
import me.ele.shop.sdk.reflect.VPackage;
import me.ele.shop.sdk.util.HttpClientUtil;
import me.ele.shop.sdk.util.SignatureUtil;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;

class NopClientInterceptor implements MethodInterceptor {
    private static HttpClientUtil httpClientUtil = new HttpClientUtil();

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    private Set<Method> declaredMethods;

    NopClientInterceptor(Class<?> nopServiceType) {
        declaredMethods = Sets.newHashSet(nopServiceType.getDeclaredMethods());
    }

    private String getDefaultPrefix(Class<?> nopServiceInterface) {
        NopService nopServiceAnnotation = nopServiceInterface.getDeclaredAnnotation(NopService.class);
        return nopServiceAnnotation.alias()[0];
    }

    private String getAction(Method method) {
        return String.format("%s.%s", getDefaultPrefix(method.getDeclaringClass()), method.getName());
    }

    @Override
    public Object intercept(Object object, Method method, Object[] arguments, MethodProxy proxy) throws Throwable {
        if (!declaredMethods.contains(method)) {
            return proxy.invokeSuper(object, arguments);
        }

        long timestamp = System.currentTimeMillis() / 1000;
        String appKey = Config.getAppKey();
        String secret = Config.getSecret();
        String action = getAction(method);
        String token = ClientContext.getToken().getOAuthToken().getAccessToken();
        // 本地校验token时效
        Date date = new Date();
        if (date.getTime() > ClientContext.getToken().getLastTime()) {
            throw new UnauthorizedException();
        }

        Map<String, Object> parameters = getParamMap(method, arguments);

        Map<String, Object> requestPayload = new HashMap<>();
        requestPayload.put("nop", "1.0.0");
        requestPayload.put("id", UUID.randomUUID().toString().toLowerCase());
        requestPayload.put("action", action);
        requestPayload.put("token", token);
        requestPayload.put("metas", new HashMap<String, Object>() {
            {
                put("app_key", appKey);
                put("timestamp", timestamp);
            }
        });
        requestPayload.put("params", parameters);
        String signature = SignatureUtil.generateSignature(appKey, secret, timestamp, action, token, parameters);
        requestPayload.put("signature", signature);

        ResponsePayload responsePayload = doRequest(requestPayload);
        if (responsePayload.getError() != null) {
            throw toException(responsePayload.getError());
        }

        return objectMapper.convertValue(responsePayload.getResult(), objectMapper.constructType(TypeToken.of(method.getGenericReturnType()).getType()));
    }

    private ResponsePayload doRequest(Map requestPayload) {
        try {
            String response = httpClientUtil.post(Config.getAPIServerUrl(), objectMapper.writeValueAsString(requestPayload));
            ResponsePayload payload = objectMapper.readValue(response, ResponsePayload.class);
            return payload;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Object> getParamMap(Method method, Object[] args) {
        Parameter[] params = method.getParameters();
        Map<String, Object> paramMap = Maps.newHashMap();
        for (int index = 0; index < args.length; index++) {
            paramMap.put(params[index].getName(), args[index]);
        }
        return paramMap;
    }

    private static final String EXCEPTION_PACKAGE = "me.ele.shop.sdk.interfaces.exception";
    private static final Map<String, Invokable> excConstructorMap = Maps.newHashMap();

    static {
        VPackage.getTypesExtendedFrom(EXCEPTION_PACKAGE, Exception.class).forEach(excType -> {
            if (!Modifier.isAbstract(excType.getModifiers())) {
                Invokable constructor = VInvoke.getConstructor(excType, String.class);
                Exception exc = VInvoke.newInstance(constructor, "");
                String code = (exc instanceof ServiceException) ?
                        ((ServiceException) exc).getCode() : ((ServerErrorException) exc).getCode();
                excConstructorMap.put(code, constructor);
            }
        });
    }

    private Exception toException(ErrorPayload error) {
        Invokable constructor = excConstructorMap.get(error.getCode());
        Exception exception;
        if (error.getCode().startsWith("BIZ_")) {
            exception = new BusinessException(error.getCode(), error.getMessage());
        } else {
            exception = VInvoke.newInstance(constructor, error.getMessage());
        }
        return exception;
    }
}
