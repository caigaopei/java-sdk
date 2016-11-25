package me.ele.shop.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.ele.shop.sdk.interceptor.ClientContext;
import me.ele.shop.sdk.interceptor.InjectionModule;
import me.ele.shop.sdk.interfaces.entity.shop.OShop;
import me.ele.shop.sdk.interfaces.exception.ServiceException;
import me.ele.shop.sdk.interfaces.service.ShopService;
import me.ele.shop.sdk.protocol.ClientCredentials;
import me.ele.shop.sdk.protocol.Token;

public class Main {
    private static Injector injector;
    private static ClientCredentials clientCredentials;
    static {
        injector = Guice.createInjector(new InjectionModule());
        clientCredentials = injector.getInstance(ClientCredentials.class);
    }

    public static void main(String[] args) throws ServiceException {
        Token token = clientCredentials.getAccessToken();
        ClientContext.setToken(token);

        ShopService shopService = injector.getInstance(ShopService.class);
        OShop shop = shopService.getShop(720030);
        System.out.println(shop);
    }


}
