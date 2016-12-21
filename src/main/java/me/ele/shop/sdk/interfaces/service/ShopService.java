package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.shop.OShop;
import me.ele.shop.sdk.interfaces.entity.shop.OSimpleShop;
import me.ele.shop.sdk.interfaces.enumeration.shop.OShopProperty;
import me.ele.shop.sdk.interfaces.exception.ServiceException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * eleme.shop 店铺服务
 */
@NopService(alias = "eleme.shop")
public interface ShopService {

    /**
     * 查询店铺信息
     *
     * @param shopId int 店铺Id|必选|908888
     * @return OShop 店铺
     */
    OShop getShop(@NotNull(message = "店铺Id不能为空") Integer shopId) throws ServiceException;

    /**
     * 更新店铺基本信息
     *
     * @param shopId     int 店铺Id|必选|908888
     * @param properties Map<OShopProperty,Object> 店铺属性|必选|"{"addressText":"上海市长宁区龙溪路虹桥路1923号","agentFee":3,"closeDescription":"商户关店1"}"
     * @return OShop 店铺
     */
    OShop updateShop(@NotNull(message = "店铺Id不能为空") Integer shopId, @NotNull(message = "店铺属性不能为空") Map<OShopProperty, Object> properties) throws ServiceException;

    /**
     * 批量获取店铺简要
     *
     * @param shopIds List<Integer> 店铺Id的列表|必选|908888
     * @return Map<Integer,OSimpleShop> 店铺简要列表
     */
    Map<Integer, OSimpleShop> mgetShopStatus(@NotNull(message = "店铺Id的列表不能为空") List<Integer> shopIds) throws ServiceException;
}
