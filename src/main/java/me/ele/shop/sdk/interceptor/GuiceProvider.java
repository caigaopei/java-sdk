package me.ele.shop.sdk.interceptor;

import com.google.inject.Provider;
import lombok.AllArgsConstructor;

import java.util.function.Supplier;

@AllArgsConstructor
public class GuiceProvider implements Provider {
    private Supplier instanceSupplier;

    public Object get() {
        return instanceSupplier.get();
    }
}