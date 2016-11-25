package me.ele.shop.sdk.reflect;

import com.google.common.collect.Maps;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkArgument;

public final class VType {
    private VType() {
    }

    private static Logger logger = Logger.getLogger("VType.class");

    private static final Map<String, Class<?>> typeMap = Maps.newHashMap();

    static {
        Primitives.allPrimitiveTypes().forEach(primitive ->
                typeMap.put(primitive.getName(), primitive));
    }

    public static Class<?> getType(String typeName) {
        if (!typeMap.containsKey(typeName)) {
            synchronized (typeMap) {
                if (!typeMap.containsKey(typeName)) {
                    Class<?> type = null;
                    try {
                        type = Class.forName(typeName);
                    } catch (ClassNotFoundException ex) {
                        // Do nothing
                    }
                    typeMap.put(typeName, type);
                }
            }
        }

        Class<?> type = typeMap.get(typeName);
        if (type == null) {
            logger.warning(String.format("Class [%s] not found.", typeName));

        }
        return type;
    }


    public static Class<?> getGenericType(Type genericType, int index) {
        checkArgument(genericType instanceof ParameterizedType, "[%s] is not a generic type.", genericType);
        Type actualType = ((ParameterizedType) genericType).getActualTypeArguments()[index];
        checkArgument(actualType instanceof Class, "No generic type info founded for index [%s] of [%s].", index, genericType);
        return (Class<?>) actualType;
    }

    public static Class<?> getGenericType(Field field, int index) {
        Type genericType = field.getGenericType();
        checkArgument((genericType instanceof ParameterizedType), "[%s] is not a generic class.", field);
        return getGenericType(genericType, index);
    }

    public static Class<?> getGenericType(Class<?> inheritedType, int index) {
        Type genericType = inheritedType.getGenericSuperclass();
        checkArgument((genericType instanceof ParameterizedType), "[%s] is not inherited from a generic class.", inheritedType);
        return getGenericType(genericType, index);
    }

    public static Class<?> getGenericType(Class<?> implementedType, Class<?> interfaceType, int index) {
        Type genericType = null;
        for (Type genericInterface : implementedType.getGenericInterfaces()) {
            if (genericInterface instanceof ParameterizedType && ((ParameterizedType) genericInterface).getRawType() == interfaceType) {
                genericType = genericInterface;
            }
        }
        checkArgument(genericType != null, "[%s] is not implemented from [%s].", implementedType, interfaceType);
        return getGenericType(genericType, index);
    }

    public static Class<?> getFirstGenericType(Type genericType) {
        return getGenericType(genericType, 0);
    }

    public static Class<?> getFirstGenericType(Field field) {
        return getGenericType(field, 0);
    }

    public static Class<?> getFirstGenericType(Class<?> inheritedType) {
        return getGenericType(inheritedType, 0);
    }

    public static Class<?> getFirstGenericType(Class<?> implementedType, Class<?> interfaceType) {
        return getGenericType(implementedType, interfaceType, 0);
    }

    /**
     * Type Token
     */

    public static <E> TypeToken<List<E>> constructListToken(TypeToken<E> elemToken) {
        return (new TypeToken<List<E>>() {
        })
                .where(new TypeParameter<E>() {
                }, elemToken);
    }

    public static <E> TypeToken<List<E>> constructListToken(Class<E> elemType) {
        return constructListToken(TypeToken.of(elemType));
    }

    public static <E> TypeToken<Set<E>> constructSetToken(TypeToken<E> elemToken) {
        return (new TypeToken<Set<E>>() {
        })
                .where(new TypeParameter<E>() {
                }, elemToken);
    }

    public static <E> TypeToken<Set<E>> constructSetToken(Class<E> elemType) {
        return constructSetToken(TypeToken.of(elemType));
    }

    public static <K, V> TypeToken<Map<K, V>> constructMapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
        return (new TypeToken<Map<K, V>>() {
        })
                .where(new TypeParameter<K>() {
                }, keyToken)
                .where(new TypeParameter<V>() {
                }, valueToken);
    }

    public static <K, V> TypeToken<Map<K, V>> constructMapToken(TypeToken<K> keyToken, Class<V> valueType) {
        return constructMapToken(keyToken, TypeToken.of(valueType));
    }

    public static <K, V> TypeToken<Map<K, V>> constructMapToken(Class<K> keyType, TypeToken<V> valueToken) {
        return constructMapToken(TypeToken.of(keyType), valueToken);
    }

    public static <K, V> TypeToken<Map<K, V>> constructMapToken(Class<K> keyType, Class<V> valueType) {
        return constructMapToken(TypeToken.of(keyType), TypeToken.of(valueType));
    }
}
