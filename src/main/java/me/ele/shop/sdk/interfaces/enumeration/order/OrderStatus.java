package me.ele.shop.sdk.interfaces.enumeration.order;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 订单状态
 */
public enum OrderStatus {
    PENDING("pending", Collections.EMPTY_LIST, "未生效订单"),
    UNPROCESSED("unprocessed", Arrays.asList((short) TOrderStatus.UNPROCESSED.getValue(), (short) TOrderStatus.PROCESSING.getValue()), "未处理订单"),
    REFUNDING("refunding", Arrays.asList((short) TOrderStatus.REFUNDING.getValue()), "退单处理中"),
    VALID("valid", Arrays.asList((short) TOrderStatus.PROCESSED_AND_VALID.getValue()), "已处理的有效订单"),
    INVALID("invalid", Arrays.asList((short) TOrderStatus.INVALID.getValue()), "无效订单"),
    SETTLED("settled", Arrays.asList((short) TOrderStatus.SETTLED.getValue()), "已完成订单");

    private String name;
    private String description;
    private List<Short> statusCodes;

    OrderStatus(String name, List<Short> statusCodes, String description) {
        this.name = name;
        this.statusCodes = statusCodes;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Short> getStatusCodes() {
        return statusCodes;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
