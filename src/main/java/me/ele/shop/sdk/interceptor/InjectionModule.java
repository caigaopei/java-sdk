package me.ele.shop.sdk.interceptor;

import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import me.ele.shop.sdk.reflect.VPackage;
import me.ele.shop.sdk.reflect.VProxy;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InjectionModule extends AbstractModule {
    private static Set<Class<?>> nopServiceTypes;

    static {
        nopServiceTypes = VPackage.getTypes("me.ele.shop.sdk.interfaces.service").stream()
                .filter(type -> type.isInterface() && !type.isAnnotation())
                .collect(Collectors.toSet());
    }

    private Map<Class<?>, Provider> providerMap = Maps.newHashMap();

    public void put(Class<?> type, Provider provider) {
        providerMap.put(type, provider);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void configure() {
        nopServiceTypes.forEach(type -> {
            Provider provider = new GuiceProvider(() -> {
                return VProxy.create(type, new NopClientInterceptor(type));
            });

            bind(type).toProvider(provider);
        });
    }
}