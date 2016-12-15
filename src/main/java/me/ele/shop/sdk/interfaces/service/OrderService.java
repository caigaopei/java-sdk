package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.order.OOrder;
import me.ele.shop.sdk.interfaces.enumeration.order.OInvalidateType;
import me.ele.shop.sdk.interfaces.exception.ServiceException;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * eleme.order 订单服务
 */
@NopService(alias = "eleme.order")
public interface OrderService {

    /**
     * 获取订单
     *
     * @param orderId String 订单Id|必选|"100027455049038461"
     * @return OOrder 订单
     */
    OOrder getOrder(@NotNull(message = "订单Id不能为空") String orderId) throws ServiceException;

    /**
     * 批量获取订单
     *
     * @param orderIds List<String> 订单Id的列表|必选|"["100027455049038461","100027455049038462"]"
     * @return Map<String,OOrder> 订单列表
     */
    Map<String, OOrder> mgetOrders(@NotNull(message = "订单Id的列表不能为空") List<String> orderIds) throws ServiceException;

    /**
     * 确认订单
     *
     * @param orderId String 订单Id|必选|"100027455049038461"
     * @return OOrder 订单
     */
    OOrder confirmOrder(@NotNull(message = "订单Id不能为空") String orderId) throws ServiceException;

    /**
     * 取消订单
     *
     * @param orderId String 订单Id|必选|"100027455049038461"
     * @param type    OInvalidateType 取消原因|必选|"fakeOrder"
     * @param remark  String 备注说明|可选|"无法取得联系"
     * @return OOrder 订单
     */
    OOrder cancelOrder(@NotNull(message = "订单Id不能为空") String orderId, @NotNull(message = "取消原因不能为空") OInvalidateType type, String remark) throws ServiceException;

    /**
     * 同意退单
     *
     * @param orderId String 订单Id|必选|"100027455049038461"
     * @return OOrder 订单
     */
    OOrder agreeRefund(@NotNull(message = "订单Id不能为空") String orderId) throws ServiceException;

    /**
     * 不同意退单
     *
     * @param orderId String 订单Id|必选|"100027455049038461"
     * @param reason  String 商家不同意退单原因|可选|"商品已经卖完"
     * @return OOrder 订单
     */
    OOrder disagreeRefund(@NotNull(message = "订单Id不能为空") String orderId, String reason) throws ServiceException;
}
