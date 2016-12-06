package me.ele.shop.sdk.interfaces.enumeration.item;

/**
 * 商品参数
 */
public enum OItemProperty {

    /**
     * 商品名称
     */
    name("商品名称"),

    /**
     * 商品单价
     */
    price("商品单价"),

    /**
     * 商品描述
     */
    description("商品描述"),

    /**
     * 图片imageHash
     */
    imageHash("图片imageHash"),

    /**
     * 标签属性集合
     */
    labels("标签属性集合"),

    /**
     * 规格
     */
    specs("规格"),

    /**
     * 商品分类
     */
    categoryId("商品分类");

    private String value;

    private OItemProperty(String value) {
        this.value = value;
    }
}
