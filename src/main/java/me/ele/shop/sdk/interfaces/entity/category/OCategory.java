package me.ele.shop.sdk.interfaces.entity.category;

import lombok.Data;

@Data
public class OCategory {
    /**
     * 饿了么商品分类ID
     */
    private long id;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 商品分类描述
     */
    private String description;

    /**
     * 是否有效
     */
    private int isValid;
}
