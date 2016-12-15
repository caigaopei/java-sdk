package me.ele.shop.sdk.interfaces.entity.shop;

import lombok.Data;

/**
 * 店铺简要
 */
@Data
public class OSimpleShop {

    /**
     * 店铺Id||988887
     */
    private int id;

    /**
     * 是否开店||1
     */
    private int isOpen;

    /**
     * 是否有效||1
     */
    private int isValid;
}
