package sdk.protocol;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import sdk.config.Config;
import sdk.interfaces.exception.*;
import sdk.oauth.Token;
import sdk.util.HttpClientUtil;
import sdk.util.SignatureUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RpcClient {

    private static HttpClientUtil httpClientUtil = new HttpClientUtil();

    static ObjectMapper objectMapper = new ObjectMapper();

    Logger logger = Logger.getLogger(this.getClass());

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
    }

    public <T> T call(String action, Map<String, Object> parameters, Token token, Type type) throws ServiceException {
        final long timestamp = System.currentTimeMillis() / 1000;
        final String appKey = Config.getAppKey();
        String secret = Config.getSecret();
        String accessToken = token.getoAuthToken().getAccessToken();
        // 本地校验token时效
        Date date = new Date();
        if (date.getTime() > token.getLastTime()) {
            throw new UnauthorizedException("token已过期，请重新申请token");
        }

        Map<String, Object> requestPayload = new HashMap();
        requestPayload.put("nop", "1.0.0");
        requestPayload.put("id", UUID.randomUUID().toString().toLowerCase());
        requestPayload.put("action", action);
        requestPayload.put("token", accessToken);
        requestPayload.put("metas", new HashMap<String, Object>() {
            {
                put("app_key", appKey);
                put("timestamp", timestamp);
            }
        });
        requestPayload.put("params", parameters);
        String signature = SignatureUtil.generateSignature(appKey, secret, timestamp, action, accessToken, parameters);
        requestPayload.put("signature", signature);

        try {
            logger.info(objectMapper.writeValueAsString(requestPayload));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ResponsePayload responsePayload = doRequest(requestPayload);
        try {
            logger.info(objectMapper.writeValueAsString(responsePayload));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if (responsePayload.getError() != null) {
            ServiceException serviceException = toException(responsePayload.getError());
            if (serviceException != null)
                throw serviceException;
            throw new ServerErrorException();
        }

        if (type == void.class)
            return null;
        return objectMapper.convertValue(responsePayload.getResult(), objectMapper.constructType(type));
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

    private ServiceException toException(ErrorPayload error) throws ServiceException {
        String code = error.getCode();
        String message = error.getMessage();
        if ("ACCESS_DENIED".equals(code))
            return new AccessDeniedException(message);
        if ("EXCEED_LIMIT".equals(code))
            return new ExceedLimitException(message);
        if ("INVALID_SIGNATURE".equals(code))
            return new InvalidSignatureException(message);
        if ("INVALID_TIMESTAMP".equals(code))
            return new InvalidTimestampException(message);
        if ("METHOD_NOT_ALLOWED".equals(code))
            return new MethodNotAllowedException(message);
        if ("PERMISSION_DENIED".equals(code))
            return new PermissionDeniedException(message);
        if ("UNAUTHORIZED".equals(code))
            return new UnauthorizedException(message);
        if ("VALIDATION_FAILED".equals(code))
            return new ValidationFailedException(message);
        if (error.getCode().startsWith("BIZ_")) {
            return new BusinessException(error.getCode(), error.getMessage());
        }
        return null;
    }
}
