package me.ele.shop.sdk.interfaces.entity.order;

import lombok.Data;

/**
 * 配菜
 */
@Data
public class OGoodsAddition {

    /**
     * 配菜Id||72970001223
     */
    private long id;

    /**
     * 配菜名称||花椰菜
     */
    private String name = "";

    /**
     * 配菜单价||3.0
     */
    private Double price = 0.0;

    /**
     * 配菜数量||2
     */
    private Integer quantity = 0;

    /**
     * 是否显示数量||true
     */
    private boolean displayQuantity;

}