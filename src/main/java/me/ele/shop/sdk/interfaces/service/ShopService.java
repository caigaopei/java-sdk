package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.shop.OShop;
import me.ele.shop.sdk.interfaces.entity.shop.OSimpleShop;
import me.ele.shop.sdk.interfaces.enumeration.shop.OShopProperty;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 店铺服务
 */
@NopService(alias = "eleme.shop")
public interface ShopService {

    OShop getShop(@NotNull int shopId);

    OShop updateShop(@NotNull int shopId, Map<OShopProperty, Object> properties);

    Map<Integer, OSimpleShop> mgetShopStatus(@NotNull List<Integer> shopIds);
}
