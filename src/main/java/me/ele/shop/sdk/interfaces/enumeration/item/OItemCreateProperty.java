package me.ele.shop.sdk.interfaces.enumeration.item;

/**
 * 创建商品属性
 */
public enum OItemCreateProperty {

    /**
     * 商品名称|必选|白切鸡
     */
    name("商品名称"),

    /**
     * 商品描述|可选|香脆可口，外焦里嫩
     */
    description("商品描述"),

    /**
     * 图片imageHash|可选|http://pic.ele.me/1929345.png
     */
    imageHash("图片imageHash"),

    /**
     * 标签属性集合|可选|
     */
    labels("标签属性集合"),

    /**
     * 规格|必选|
     */
    specs("规格");

    private String value;

    private OItemCreateProperty(String value) {
        this.value = value;
    }
}
