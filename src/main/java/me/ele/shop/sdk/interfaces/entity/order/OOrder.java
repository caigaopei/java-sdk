package me.ele.shop.sdk.interfaces.entity.order;

import lombok.Data;
import me.ele.shop.sdk.interfaces.enumeration.order.OOrderRefundStatus;
import me.ele.shop.sdk.interfaces.enumeration.order.OOrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 */
@Data
public class OOrder {

    /**
     * 顾客送餐地址||"近铁城市广场"
     */
    private String address;

    /**
     * 下单时间||"2016-11-30T12:15:53"
     */
    private LocalDateTime createdAt;

    /**
     * 订单生效时间||"2016-11-30T12:15:53"
     *
     * @desc 即支付时间
     */
    private LocalDateTime activeAt;

    /**
     * 配送费||2.0
     */
    private double deliverFee;

    /**
     * 预计送达时间||"2016-11-30T13:15:53"
     */
    private LocalDateTime deliverTime;

    /**
     * 订单备注||"不要香菜"
     */
    private String description;

    /**
     * 订单详细类目的列表||"[{"items":[{"categoryId":1123123,"id":2341123,"name":"奶茶","price":10.0,"quantity":30,"total":300.0}],"name":"一个分组","type":"discount"}]"
     */
    private List<OGoodsGroup> groups = new ArrayList<>();

    /**
     * 发票抬头||"拉扎斯网络科技(上海)有限公司"
     */
    private String invoice;

    /**
     * 是否预订单||true
     */
    private boolean isBook;

    /**
     * 是否在线支付||false
     */
    private boolean isOnlinePaid;

    /**
     * 订单Id||"100027455049038461"
     */
    private String id;

    /**
     * 顾客联系电话||["13507701342"]
     */
    private List<String> phoneList = new ArrayList<>();

    /**
     * 店铺Id||968514
     */
    private int shopId;

    /**
     * 店铺名称||"实验餐厅"
     */
    private String shopName;

    /**
     * 店铺当日订单流水号||89
     */
    private int daySn;

    /**
     * 订单状态||"settled"
     */
    private OOrderStatus status;

    /**
     * 退单状态||"noRefund"
     */
    private OOrderRefundStatus refundStatus;

    /**
     * 用户Id||13524069
     */
    private int userId;

    /**
     * 订单总价||5.0
     *
     * @desc 用户实付(单位：元）
     */
    private double totalPrice;

    /**
     * 原始价格||5.0
     *
     * @desc 优惠前的价格，即菜价加上配送费和打包费，单位：元
     */
    private double originalPrice;

    /**
     * 订单收货人||"张三"
     */
    private String consignee;

    /**
     * 订单收货地址经纬度||"121.83317,31.514559"
     */
    private String deliveryGeo;

    /**
     * 顾客送餐详情地址||"近铁城市广场（普陀区金沙江路1518弄)"
     */
    private String deliveryPoiAddress;

    /**
     * 是否需要发票||true
     */
    private boolean invoiced;

    /**
     * 店铺实收||7.0
     */
    private double income;

    /**
     * 饿了么服务费率||0.0
     */
    private double serviceRate;

    /**
     * 饿了么服务费||0.0
     */
    private double serviceFee;

    /**
     * 订单中红包金额||1.0
     */
    private double hongbao;

    /**
     * 餐盒费||1.0
     */
    private double packageFee;

    /**
     * 订单活动总额||12.0
     */
    private double activityTotal;

    /**
     * 店铺承担活动费用||6.0
     */
    private double shopPart;

    /**
     * 饿了么承担活动费用||6.0
     */
    private double elemePart;

    /**
     * 降级标识||false
     *
     * @desc true为已降级，false为未降级。
     * 平台为尽可能促成交易，会在一部分字段未生成的时候（如活动补贴），将订单生成。
     * 如果需要完整的订单的订单信息，需要事后在降级标记为false时再进行读取。
     */
    private boolean downgraded;
}
