package me.ele.shop.sdk.interfaces.entity.shop;

import lombok.Data;

@Data
public class OSimpleShop {

    /**
     * 饿了么店铺id
     */
    private int id;

    /**
     * 是否开店(是为1，否为0)
     */
    private int isOpen;

    /**
     * 是否有效(1有效，0无效）
     */
    private int isValid;
}
