package me.ele.shop.sdk.interfaces.entity.item;

import lombok.Data;

/**
 * 标签
 */
@Data
public class OLabel {

    /**
     * 是否招牌菜||1
     */
    private int isFeatured;

    /**
     * 是否配菜||0
     */
    private int isGum;

    /**
     * 是否新菜||0
     */
    private int isNew;

    /**
     * 是否辣||0
     */
    private int isSpicy;
}
