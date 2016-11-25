package me.ele.shop.sdk.reflect;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public final class VMethod {
    private VMethod() {}

    private static final Map<Method, Method> overriddenMap = Maps.newHashMap();

    private static synchronized void initializeOverriddenMethod(Method method) {
        if (overriddenMap.containsKey(method)) {
            return;
        }

        Method overridden = null;

        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?>[] exceptionTypes = method.getExceptionTypes();

        Class<?> declaringClass = method.getDeclaringClass();
        Set<Class<?>> types = Sets.newHashSet(declaringClass.getInterfaces());
        if (declaringClass.getSuperclass() != null) {
            types.add(declaringClass.getSuperclass());
        }
        do {
            Set<Class<?>> newTypes = Sets.newHashSet();
            for (Class<?> type : types) {
                for (Method fMethod : type.getDeclaredMethods()) {
                    // name
                    if (!fMethod.getName().equals(name)) {
                        continue;
                    }

                    // return type
                    if (!fMethod.getReturnType().isAssignableFrom(returnType)) {
                        continue;
                    }

                    // parameter length
                    Class<?>[] fParameterTypes = fMethod.getParameterTypes();
                    if (parameterTypes.length != fParameterTypes.length) {
                        continue;
                    }

                    // paramter types
                    boolean isParameterTypesAssignable = true;
                    for (int index = 0; index < parameterTypes.length; index++) {
                        if (!fParameterTypes[index].isAssignableFrom(parameterTypes[index])) {
                            isParameterTypesAssignable = false;
                            break;
                        }
                    }
                    if (!isParameterTypesAssignable) {
                        continue;
                    }

                    // exceptionTypes
                    boolean isExceptionTypesAssignable = true;
                    Set<Class<?>> fExceptionTypes = Sets.newHashSet(fMethod.getExceptionTypes());
                    for (Class<?> exceptionType : exceptionTypes) {
                        if (!fExceptionTypes.stream().anyMatch(et -> et.isAssignableFrom(exceptionType))) {
                            isExceptionTypesAssignable = false;
                            break;
                        }
                    }
                    if (!isExceptionTypesAssignable) {
                        continue;
                    }

                    // Founded
                    overridden = fMethod;
                    name = fMethod.getName();
                    returnType = fMethod.getReturnType();
                    parameterTypes = fMethod.getParameterTypes();
                    exceptionTypes = fMethod.getExceptionTypes();
                }
                newTypes.addAll(Sets.newHashSet(type.getInterfaces()));
                if (type.getSuperclass() != null) {
                    newTypes.add(type.getSuperclass());
                }
            }
            types = newTypes;
        } while (!types.isEmpty());

        overriddenMap.put(method, overridden);
    }

    public static Method getOverriddenMethod(Method method) {
        if (!overriddenMap.containsKey(method)) {
            initializeOverriddenMethod(method);
        }
        return overriddenMap.get(method);
    }

    private static Set<String> objectMethodNames = Sets.newHashSet();
    static {
        Sets.newHashSet(Object.class.getMethods()).forEach(method -> objectMethodNames.add(method.getName()));
    }

    public static boolean isObjectMethod(Method method) {
        return objectMethodNames.contains(method.getName());
    }
}
