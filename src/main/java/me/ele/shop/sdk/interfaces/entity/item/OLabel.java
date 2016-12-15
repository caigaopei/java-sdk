package me.ele.shop.sdk.interfaces.entity.item;

import lombok.Data;

/**
 * 标签
 */
@Data
public class OLabel {

    /**
     * 是否招牌菜||1
     *
     * @desc 0:不是招牌菜 1:是招牌菜
     */
    private int isFeatured;

    /**
     * 是否配菜||0
     *
     * @desc 0:不是配菜 1:是招配菜
     */
    private int isGum;

    /**
     * 是否新菜||0
     *
     * @desc 0:不是新菜 1:是新菜
     */
    private int isNew;

    /**
     * 是否辣||0
     *
     * @desc 0:不辣 1:辣
     */
    private int isSpicy;
}
