package me.ele.shop.sdk.interfaces.entity.item;

import lombok.Data;

import java.util.List;

/**
 * 商品
 */
@Data
public class OItem {

    /**
     * 商品描述||香脆可口，外焦里嫩
     */
    private String description;

    /**
     * 商品Id||27970000058
     */
    private long id;

    /**
     * 商品名||白切鸡
     */
    private String name;

    /**
     * 是否有效||1
     */
    private int isValid;

    /**
     * 最近一个月的售出份数||30
     */
    private int recentPopularity;

    /**
     * 店铺Id||987777
     */
    private int shopId;

    /**
     * 店铺名称||烤鸡大王
     */
    private String shopName;

    /**
     * 商品图片||http://pic.ele.me/1929345.png
     */
    private String imageUrl;

    /**
     * 标签||
     */
    private OLabel labels;

    /**
     * 规格的列表||
     */
    private List<OSpec> specs;

}
