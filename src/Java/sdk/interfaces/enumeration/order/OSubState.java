package sdk.interfaces.enumeration.order;

/**
 * 运单子状态
 */
public enum OSubState {
    /**
     * 商家取消
     */
    merchantReason("merchantReason", 1, "cancelled", "商家取消"),
    /**
     * 配送商取消
     */
    carrierReason("carrierReason", 2, "cancelled", "配送商取消"),
    /**
     * 用户取消
     */
    userReason("userReason", 3, "cancelled", "用户取消"),
    /**
     * 物流系统取消
     */
    systemReason("systemReason", 4, "cancelled", "物流系统取消"),

    /**
     * 呼叫配送晚
     */
    merchantCallLateError("merchantCallLateError", 5, "exception", "呼叫配送晚"),
    /**
     * 餐厅出餐问题
     */
    merchantFoodError("merchantFoodError", 6, "exception", "餐厅出餐问题"),
    /**
     * 商户中断配送
     */
    merchantInterruptDeliveryError("merchantInterruptDeliveryError", 7, "exception", "商户中断配送"),
    /**
     * 用户不接电话
     */
    userNotAnswerError("userNotAnswerError", 8, "exception", "用户不接电话"),
    /**
     * 用户退单
     */
    userReturnOrderError("userReturnOrderError", 9, "exception", "用户退单"),
    /**
     *用户地址错误
     */
    userAddressError("userAddressError", 10, "exception", "用户地址错误"),
    /**
     * 超出服务范围
     */
    deliveryOutOfService("deliveryOutOfService", 11, "exception", "超出服务范围"),
    /**
     * 骑手标记异常
     */
    carrierRemarkExceptionError("carrierRemarkExceptionError", 12, "exception", "骑手标记异常"),
    /**
     * 系统自动标记异常--订单超过3小时未送达
     */
    systemMarkedError("systemMarkedError", 13, "exception", "系统自动标记异常--订单超过3小时未送达"),
    /**
     * 其他异常
     */
    otherError("otherError", 14, "exception", "其他异常"),
    /**
     * 配送超时，系统标记异常
     */
    deliveryTimeout("deliveryTimeout", 15, "exception", "配送超时，系统标记异常"),

    /**
     * 只支持在线订单
     */
    onlinePayError("onlinePayError", 101, "reject", "只支持在线订单"),
    /**
     * 超出服务范围
     */
    consumerLocationTooFarError("consumerLocationTooFarError", 102, "reject", "超出服务范围"),
    /**
     * 请求配送过晚, 无法呼叫
     */
    merchantPushTooLateError("merchantPushTooLateError", 103, "reject", "请求配送过晚, 无法呼叫"),
    /**
     * 系统异常
     */
    systemError("systemError", 104, "reject", "系统异常");


    private String name;
    private int value;
    private String state;
    private String description;

    OSubState(String name, int value, String state, String description) {
        this.name = name;
        this.value = value;
        this.state = state;
        this.description = description;
    }

    public int getValue() {
        return this.value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
