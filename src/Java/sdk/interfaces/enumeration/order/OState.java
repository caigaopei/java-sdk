package sdk.interfaces.enumeration.order;

public enum OState {
    /**
     * 待分配（物流系统已生成运单，待分配配送商）
     */
    tobeAssignedMerchant("tobeAssignedMerchant", 1, "待分配（物流系统已生成运单，待分配配送商）"),
    /**
     * 待分配（配送系统已接单，待分配配送员）
     */
    tobeAssignedCourier("tobeAssignedCourier", 2, "待分配（配送系统已接单，待分配配送员）"),
    /**
     * 待取餐（已分配给配送员，配送员未取餐）
     */
    tobeFetched("tobeFetched", 3, "待取餐（已分配给配送员，配送员未取餐）"),
    /**
     * 配送中（配送员已取餐，正在配送）
     */
    delivering("delivering", 4, "配送中（配送员已取餐，正在配送）"),
    /**
     * 配送成功（配送员配送完成）
     */
    completed("completed", 5, "配送成功（配送员配送完成）"),
    /**
     * 配送取消（商家可以重新发起配送）
     */
    cancelled("cancelled", 6, "配送取消（商家可以重新发起配送）"),
    /**
     * 配送异常
     */
    exception("exception", 7, "配送异常"),
    /**
     * 已到店(配送员已到店)
     */
    arrived("arrived", 8, "已到店(配送员已到店)"),
    /**
     * 商家自行配送
     */
    selfDelivery("selfDelivery", 9, "商家自行配送"),
    /**
     * 商家不再配送
     */
    noMoreDelivery("noMoreDelivery", 10, "商家不再配送"),
    /**
     * 物流拒单
     */
    reject("reject", 101, "物流拒单");

    private String name;
    private int value;
    private String description;

    OState(String name, int value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
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
