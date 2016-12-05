package me.ele.shop.sdk.interfaces.entity.item;

import lombok.Data;

/**
 * 规格
 */
@Data
public class OSpec {

    /**
     * 规格Id||72970000222
     */
    private long specId;

    /**
     * 名称||大份
     */
    private String name;

    /**
     * 商品价格||18.0
     */
    private double price;

    /**
     * 库存量||9000
     */
    private int stock;

    /**
     * 最大库存量||10000
     */
    private int maxStock;

    /**
     * 包装费||3.0
     */
    private double packingFee;

    /**
     * 是否上架||1
     */
    private int onShelf;
}
