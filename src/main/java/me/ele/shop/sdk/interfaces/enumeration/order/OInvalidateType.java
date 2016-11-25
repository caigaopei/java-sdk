package me.ele.shop.sdk.interfaces.enumeration.order;

/**
 * 订单无效类型
 */
public enum OInvalidateType {
    others(0, "others", "其他原因"),
    fackOrder(1, "fakeOrder", "用户信息不符"),
    duplicateOrder(2, "duplicateOrder", "用户重复下单"),
    contactRestaurantFailed(3, "contactRestaurantFailed", "联系不上商家"),
    contactUserFailed(4, "contactUserFailed", "联系不上用户"),
    foodSoldOut(5, "foodSoldOut", "商品已经售完"),
    restaurantClosed(6, "restaurantClosed", "商家已经打烊"),
    distanceTooFar(7, "distanceTooFar", "超出配送范围"),
    restaurantTooBusy(8, "restaurantTooBusy", "商家现在太忙"),
    forceRejectOrder(9, "forceRejectOrder", "用户申请取消"),
    deliveryCheckFoodUnqualified(10, "deliveryCheckFoodUnqualified", "配送方检测餐品不合格"),
    deliveryFault(11, "deliveryFault", "配送出现问题"),
    replaceOrder(12, "replaceOrder", "订单被替换"),
    userCancelOrder(13, "userCancelOrder", "用户退单"),
    longTimeToWait(14, "longTimeToWait", "风控取消订单"),
    riskOrder(15, "riskOrder", "风控取消订单"),
    lackOfCapacity(16, "lackOfCapacity", "暂时无法配送"),
    notSatisfiedDeliveryRequirement(17, "notSatisfiedDeliveryRequirement", "不满足起送要求"),
    restaurantSlowConfirm(18, "restaurantSlowConfirm", "商家接单慢"),
    userAbandonBuy(19, "userAbandonBuy", "我不想买了"),
    userRebuy(20, "userRebuy", "我想重新点"),
    longDeliveryTime(21, "longDeliveryTime", "配送时间过长"),
    timeoutNotPaid(22, "timeoutNotPaid", "超时未支付"),
    paymentFault(23, "paymentFault", "支付有问题"),
    goodsWrong(24, "goodsWrong", "商品错送漏送"),
    goodsQuality(25, "goodsQuality", "商品质量问题"),
    missGoods(26, "missGoods", "没有收到商品");

    private int value;
    private String name;
    private String description;

    private OInvalidateType(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public static OInvalidateType findValue(int type) {
        for (OInvalidateType invalidStatus : values()) {
            if (invalidStatus.getValue() == type) {
                return invalidStatus;
            }
        }
        return OInvalidateType.others;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
