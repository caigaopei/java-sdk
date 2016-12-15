package me.ele.shop.sdk.interfaces.entity.item;

import lombok.Data;

import java.util.List;

/**
 * 商品以及商品规格
 */
@Data
public class OItemIdWithSpecIds {

    /**
     * 商品Id|必选|27970000058
     */
    private long itemId;

    /**
     * 商品规格Id的列表|必选|"[72970000221,72970000222,72970000225]"
     */
    private List<Long> itemSpecIds;

}
