package me.ele.shop.sdk.interfaces.entity.order;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜品
 */
@Data
public class Item {
    /**
     * 菜品id
     */
    private long id;
    /**
     * 食物名称
     */
    private String name = "";
    /**
     * 分类Id
     */
    private int categoryId = 0;
    /**
     * 食物单价
     */
    private double price = 0.0;
    /**
     * 食物数量
     */
    private int quantity = 0;
    /**
     * 总价
     */
    private double total = 0.0;
    /**
     * 菜品折扣,兼容老数据<br>
     * 已过期
     */
    @Deprecated
    private double discount = 0;
    /**
     * 是否显示数量
     */
    private boolean displayQuantity;

    /**
     * 配菜
     */
    private List<Addition> additions = new ArrayList<>();

}
