package me.ele.shop.sdk.interfaces.service;


import me.ele.shop.sdk.anotation.NopService;
import me.ele.shop.sdk.interfaces.entity.order.OOrder;
import me.ele.shop.sdk.interfaces.enumeration.order.OInvalidateType;
import me.ele.shop.sdk.interfaces.exception.BusinessException;

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
     * @param orderId String 饿了么订单ID 
     * @return OOrder
     */
    OOrder getOrder(@NotNull(message = "订单号不能为空") String orderId);

    /**
     * 批量获取订单
     *
     * @param orderIds List<String> 饿了么订单ID
     * @return Map<String, OOrder>
     */
    Map<String, OOrder> mgetOrders(@NotNull(message = "订单号不能为空") List<String> orderIds);

    /**
     * 确认订单
     *
     * @param orderId String 饿了么订单ID
     * @return OOrder
     */
    OOrder confirmOrder(@NotNull(message = "订单号不能为空") String orderId) throws BusinessException;

    /**
     * 取消订单
     *
     * @param orderId String 饿了么订单ID
     * @param type    OInvalidateType 取消原因
     * @param remark  String 备注说明
     * @return OOrder
     */
    OOrder cancelOrder(@NotNull(message = "订单号不能为空") String orderId, @NotNull(message = "取消原因不能为空") OInvalidateType type, String remark) throws BusinessException;

    /**
     * 同意退单
     *
     * @param orderId String 饿了么订单ID
     * @return OOrder
     */
    OOrder agreeRefund(@NotNull(message = "订单号不能为空") String orderId) throws BusinessException;

    /**
     * 不同意退单
     *
     * @param orderId String 饿了么订单ID
     * @param reason  String 商家不同意退单原因
     * @return OOrder
     */
    OOrder disagreeRefund(@NotNull(message = "订单号不能为空") String orderId, String reason) throws BusinessException;
}
