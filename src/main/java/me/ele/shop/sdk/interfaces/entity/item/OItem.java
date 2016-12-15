package me.ele.shop.sdk.interfaces.entity.item;

import lombok.Data;

import java.util.List;

/**
 * 商品
 */
@Data
public class OItem {

    /**
     * 商品描述||"香脆可口，外焦里嫩"
     */
    private String description;

    /**
     * 商品Id||27970000058
     */
    private long id;

    /**
     * 商品名||"白切鸡"
     */
    private String name;

    /**
     * 是否有效||1
     *
     * @desc 0:无效 1:有效
     */
    private int isValid;

    /**
     * 最近一个月的售出份数||30
     */
    private int recentPopularity;

    /**
     * 商品分类Id||69093224
     */
    private long categoryId;

    /**
     * 店铺Id||987777
     */
    private int shopId;

    /**
     * 店铺名称||"烤鸡大王"
     */
    private String shopName;

    /**
     * 商品图片||"http://pic.ele.me/1929345.png"
     */
    private String imageUrl;

    /**
     * 标签||"{"isFeatured":0,"isGum":0,"isNew":1,"isSpicy":1}"
     */
    private OLabel labels;

    /**
     * 规格的列表||"[{"maxStock":100,"name":"大份","onShelf":1,"packingFee":1.0,"price":19.9,"specId":0,"stock":0},{"maxStock":100,"name":"中分","onShelf":1,"packingFee":1.0,"price":19.9,"specId":0,"stock":0}]"
     */
    private List<OSpec> specs;

}
