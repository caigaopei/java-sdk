package me.ele.shop.sdk.interfaces.enumeration.shop;

/**
 * 店铺可更新属性
 */
public enum OShopProperty {

    /**
     * 店铺地址
     */
    addressText("店铺地址"),


    /**
     * longitude和latitude用英文逗号分隔
     */
    geo("ongitude和latitude用英文逗号分隔"),


    /**
     * 配送费
     */
    agentFee("配送费"),


    /**
     * 关店描述信息
     */
    closeDescription("关店描述信息"),


    /**
     * 配送额外说明
     */
    deliverDescription("配送额外说明"),


    /**
     * 店铺简介
     */
    description("店铺简介"),


    /**
     * 店铺名称
     */
    name("店铺名称"),


    /**
     * 是否接受预定
     */
    isBookable("是否接受预定"),


    /**
     * 店铺营业时间，多个时间用英文逗号分隔：10:00-13:00,18:00-21:00
     */
    openTime("店铺营业时间，多个时间用英文逗号分隔：10:00-13:00,18:00-21:00"),


    /**
     * 店铺联系电话，多个用英文逗号分隔
     */
    phone("店铺联系电话"),


    /**
     * 店铺公告信息
     */
    promotionInfo("店铺公告信息"),


    /**
     * 店铺Logo的图片image_hash（如何获得 /api/merchant/image ）
     */
    logoImageHash("店铺Logo的图片image_hash（如何获得 /api/merchant/image ）"),


    /**
     * 是否支持开发票(0 代表不支持，1 代表支持)
     */
    invoice("是否支持开发票(0 代表不支持，1 代表支持)"),


    /**
     * 支持的最小发票金额
     */
    invoiceMinAmount("支持的最小发票金额"),


    /**
     * 满xx元免配送费
     */
    noAgentFeeTotal("满xx元免配送费"),


    /**
     * 店铺是否有效（上线、下线），0为无效，1为有效
     */
    isValid("店铺是否有效（上线、下线），0为无效，1为有效"),


    /**
     * 订单打包费，对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。
     */
    packingFee("订单打包费，对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。");

    private String value;

    private OShopProperty(String value) {
        this.value = value;
    }
}
