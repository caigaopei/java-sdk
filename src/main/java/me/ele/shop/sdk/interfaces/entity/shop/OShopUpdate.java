package me.ele.shop.sdk.interfaces.entity.shop;

import lombok.Data;

/**
 * 店铺的更新参数
 */
@Data
public class OShopUpdate {

    /**
     * 店铺地址
     */
    private String addressText;


    /**
     * longitude和latitude用英文逗号分隔
     */
    private String geo;


    /**
     * 配送费
     */
    private Short agentFee;


    /**
     * 关店描述信息
     */
    private String closeDescription;


    /**
     * 配送额外说明
     */
    private String deliverDescription;


    /**
     * 店铺简介
     */
    private String description;


    /**
     * 店铺名称
     */
    private String name;


    /**
     * 是否接受预定
     */
    private Short isBookable;


    /**
     * 店铺营业时间，多个时间用英文逗号分隔：10:00-13:00,18:00-21:00
     */
    private String openTime;


    /**
     * 店铺联系电话，多个用英文逗号分隔
     */
    private String phone;


    /**
     * 店铺公告信息
     */
    private String promotionInfo;


    /**
     * 店铺Logo的图片image_hash（如何获得 /api/merchant/image ）
     */
    private String logoImageHash;


    /**
     * 是否支持开发票(0 代表不支持，1 代表支持)
     */
    private Short invoice;


    /**
     * 支持的最小发票金额
     */
    private Double invoiceMinAmount;


    /**
     * 满xx元免配送费
     */
    private Integer noAgentFeeTotal;


    /**
     * 店铺是否有效（上线、下线），0为无效，1为有效
     */
    private Short isValid;


    /**
     * 订单打包费，对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。
     */
    private Double packingFee;

}
