package me.ele.shop.sdk.interfaces.entity.order;


import me.ele.shop.sdk.interfaces.enumeration.order.TOrderRefundStatus;

import java.util.Arrays;
import java.util.List;


/**
 * 退单状态
 */
public enum OrderRefundStatus {
    NO_REFUND("noRefund", Arrays.asList((short) TOrderRefundStatus.NO_REFUND.getValue()), "未申请退单"),
    //REFUND_MARK是指新退单,需要查询其他的接口来查询真正的状态
    //, (short) TOrderRefundStatus.REFUND_MARK.getValue()
    APPLIED("applied", Arrays.asList((short) TOrderRefundStatus.LATER_REFUND_REQUEST.getValue()), "用户申请退单"),
    REJECTED("rejected", Arrays.asList((short) TOrderRefundStatus.LATER_REFUND_RESPONSE.getValue()), "餐厅拒绝退单"),
    ARBITRATING("arbitrating", Arrays.asList((short) TOrderRefundStatus.LATER_REFUND_ARBITRATING.getValue()), "客服仲裁中"),
    //(short) TOrderRefundStatus.EARLY_REFUND_SUCCESS.getValue(), 永远不会存在
    FAILED("failed", Arrays.asList((short) TOrderRefundStatus.LATER_REFUND_FAIL.getValue()), "退单失败"),
    SUCCESSFUL("successful", Arrays.asList((short) TOrderRefundStatus.LATER_REFUND_SUCCESS.getValue()), "退单成功");

    private String name;
    private String description;
    private List<Short> refundStatusCodes;

    OrderRefundStatus(String name, List<Short> refundStatusCodes, String description) {
        this.name = name;
        this.refundStatusCodes = refundStatusCodes;
        this.description = description;
    }

    public static OrderRefundStatus getOrderRefundStatus(int statusCode) {
        short shortCode = Integer.valueOf(statusCode).shortValue();
        return Arrays.stream(OrderRefundStatus.values())
                .filter(status -> status.getRefundStatusCodes().contains(shortCode))
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Short> getRefundStatusCodes() {
        return refundStatusCodes;
    }
}
