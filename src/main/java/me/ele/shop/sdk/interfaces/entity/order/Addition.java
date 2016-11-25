package me.ele.shop.sdk.interfaces.entity.order;

import lombok.Data;

@Data
public class Addition {
    private long id;
    /**
     * 配菜名称
     */
    private String name = "";//
    /**
     * 配菜单价
     */
    private Double price = 0.0;//
    /**
     * 配菜数量
     */
    private Integer quantity = 0;//
    /**
     * 是否显示数量
     */
    private boolean displayQuantity;
    /**
     * 菜品折扣,兼容老数据<br>
     * 已过期
     */
    @Deprecated
    private double discount = 0;

}