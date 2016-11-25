package me.ele.shop.sdk.reflect;

import com.google.common.base.MoreObjects;

import java.net.URL;

public final class VLoader {
    private VLoader() {}

    private static ClassLoader loader = MoreObjects.firstNonNull(
            Thread.currentThread().getContextClassLoader(),
            VLoader.class.getClassLoader());

    public static ClassLoader getLoader() {
        return loader;
    }

    public static URL getResourceUrl(String resourcePath) {
        return loader.getResource(resourcePath);
    }
}
