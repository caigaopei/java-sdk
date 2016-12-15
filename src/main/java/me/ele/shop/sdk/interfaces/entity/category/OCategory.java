package me.ele.shop.sdk.interfaces.entity.category;

import lombok.Data;

/**
 * 商品分类
 */
@Data
public class OCategory {
    /**
     * 商品分类Id||26940000135
     */
    private long id;

    /**
     * 商品分类名称||"家常菜"
     */
    private String name;

    /**
     * 商品分类描述||"家庭日常的小炒"
     */
    private String description;

    /**
     * 是否有效||1
     *
     * @desc 0:无效 1:有效
     */
    private int isValid;
}
