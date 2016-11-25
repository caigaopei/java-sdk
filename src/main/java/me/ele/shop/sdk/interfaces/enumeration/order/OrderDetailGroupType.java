package me.ele.shop.sdk.interfaces.enumeration.order;

public enum OrderDetailGroupType {
    /**
     * 正常的菜品
     */
    NORMAL("normal", "正常的菜品"),
    /**
     * 配送费等
     */
    EXTRA("extra", "配送费等"),
    /**
     * 折扣,如红包,满减等
     */
    DISCOUNT("discount", "折扣,如红包,满减等");

    private String name;
    private String description;

    OrderDetailGroupType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getName();
    }
}
