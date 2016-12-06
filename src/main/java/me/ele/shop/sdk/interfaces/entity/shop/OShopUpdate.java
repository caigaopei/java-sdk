package me.ele.shop.sdk.interfaces.entity.shop;

import lombok.Data;

/**
 * 店铺的更新参数
 */
@Data
public class OShopUpdate {

    /**
     * 店铺地址||上海市长宁区龙溪路虹桥路1923号
     */
    private String addressText;


    /**
     * 经纬度，longitude和latitude用英文逗号分隔||111.223,22.233
     */
    private String geo;


    /**
     * 配送费||3
     */
    private Short agentFee;


    /**
     * 关店描述信息||业务繁忙
     */
    private String closeDescription;


    /**
     * 配送区域说明||超过5公里，100元起送
     */
    private String deliverDescription;


    /**
     * 店铺简介||便宜好吃的小食
     */
    private String description;


    /**
     * 店铺名称||烤鸭大王
     */
    private String name;


    /**
     * 是否接受预定||1
     */
    private Short isBookable;


    /**
     * 店铺营业时间||10:00-13:00,18:00-21:00
     *
     * @desc 多个时间用英文逗号分隔
     */
    private String openTime;


    /**
     * 店铺联系电话||18516307705,13482893679
     *
     * @desc 多个用英文逗号分隔
     */
    private String phone;


    /**
     * 店铺公告信息||本周全场半价
     */
    private String promotionInfo;


    /**
     * 店铺Logo的图片imageHash|可选|3077080f760e7bf0fc985e23dd3e36e2
     *
     * @desc 如何获得 /api/merchant/image
     */
    private String logoImageHash;


    /**
     * 是否支持开发票||1
     */
    private Short invoice;


    /**
     * 支持的最小发票金额||100.0
     */
    private Double invoiceMinAmount;


    /**
     * 满xx元免配送费||20
     */
    private Integer noAgentFeeTotal;


    /**
     * 店铺是否有效（上线、下线）||1
     */
    private Short isValid;

    /**
     * 订单打包费||2.0
     *
     * @desc 对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。
     */
    private Double packingFee;

    /**
     * 配送范围||详情请咨询饿了么
     */
    private String deliverGeoJson;

}
