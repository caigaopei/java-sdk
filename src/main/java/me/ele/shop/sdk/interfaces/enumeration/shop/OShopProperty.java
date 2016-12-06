package me.ele.shop.sdk.interfaces.enumeration.shop;

/**
 * 店铺可更新属性
 */
public enum OShopProperty {

    /**
     * 店铺地址|可选|上海市长宁区龙溪路虹桥路1923号
     */
    addressText("店铺地址"),

    /**
     * 经纬度，longitude和latitude用英文逗号分隔|可选|111.223,22.233
     */
    geo("ongitude和latitude用英文逗号分隔"),

    /**
     * 配送费|可选|3
     */
    agentFee("配送费"),

    /**
     * 关店描述信息|可选|业务繁忙
     */
    closeDescription("关店描述信息"),

    /**
     * 配送区域说明|可选|超过5公里，100元起送
     */
    deliverDescription("配送额外说明"),

    /**
     * 配送范围|可选|详情请咨询饿了么
     */
    deliverGeoJson("配送范围，详情请咨询饿了么"),

    /**
     * 店铺简介|可选|便宜好吃的小食
     */
    description("店铺简介"),

    /**
     * 店铺名称|可选|烤鸭大王
     */
    name("店铺名称"),

    /**
     * 是否接受预定||1
     */
    isBookable("是否接受预定"),

    /**
     * 店铺营业时间||10:00-13:00,18:00-21:00
     *
     * @desc 多个时间用英文逗号分隔
     */
    openTime("店铺营业时间，多个时间用英文逗号分隔：10:00-13:00,18:00-21:00"),

    /**
     * 店铺联系电话||18516307705,13482893679
     *
     * @desc 多个用英文逗号分隔
     */
    phone("店铺联系电话"),

    /**
     * 店铺公告信息||本周全场半价
     */
    promotionInfo("店铺公告信息"),

    /**
     * 店铺Logo的图片imageHash|可选|3077080f760e7bf0fc985e23dd3e36e2
     *
     * @desc 如何获得 /api/merchant/image
     */
    logoImageHash("店铺Logo的图片image_hash（如何获得 /api/merchant/image ）"),

    /**
     * 是否支持开发票||1
     */
    invoice("是否支持开发票(0 代表不支持，1 代表支持)"),

    /**
     * 支持的最小发票金额||100.0
     */
    invoiceMinAmount("支持的最小发票金额"),

    /**
     * 满xx元免配送费||20
     */
    noAgentFeeTotal("满xx元免配送费"),

    /**
     * 店铺是否有效（上线、下线）||1
     */
    isValid("店铺是否有效（上线、下线），0为无效，1为有效"),

    /**
     * 订单打包费||2.0
     *
     * @desc 对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。
     */
    packingFee("订单打包费，对于该店铺的每张订单，如果有店铺订单打包费，则采用该值；如果没有，则根据订单中的菜品来决定打包费。注：设置该值为 -1 表示禁用该值。");

    private String value;

    private OShopProperty(String value) {
        this.value = value;
    }
}
