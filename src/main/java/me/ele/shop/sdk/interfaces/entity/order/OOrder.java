package me.ele.shop.sdk.interfaces.entity.order;

import lombok.Data;
import me.ele.shop.sdk.interfaces.enumeration.order.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class OOrder {

    /**
     * 顾客送餐地址
     */
    private String address;

    /**
     * 下单时间
     */
    private LocalDateTime createdAt;

    /**
     * 订单生效时间(即支付时间)
     */
    private LocalDateTime activeAt;

    /**
     * 配送费
     */
    private double deliverFee;

    /**
     * 预计送达时间
     */
    private LocalDateTime deliverTime;

    /**
     * 订单备注
     */
    private String description;

    /**
     * 订单详细类目列表
     */
    private List<Group> groups = new ArrayList<>();

    /**
     * 发票抬头
     */
    private String invoice;

    /**
     * 是否预订单
     */
    private boolean isBook;

    /**
     * 是否在线支付
     */
    private boolean isOnlinePaid;

    /**
     * 饿了么订单id
     */
    private String orderId;

    /**
     * 顾客联系电话
     */
    private List<String> phoneList = new ArrayList<>();

    /**
     * 店铺id, 接口调用时使用的ID
     */
    private int shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺当日订单序号
     */
    private int shopNumber;

    /**
     * 订单状态
     */
    private OrderStatus status;

    /**
     * 退单状态
     */
    private OrderRefundStatus refundStatus;

    /**
     * 用户id
     */
    private int userId;

//    /**
//     * 用户名
//     */
//    private String userName;

    /**
     * 订单总价,用户实付(单位：元）
     */
    private double totalPrice;

    /**
     * 原始价格
     * （优惠前的价格，即菜价加上配送费和打包费，单位：元）
     */
    private double originalPrice;

    /**
     * 订单收货人，例如：张三
     */
    private String consignee;

    /**
     * 订单收货地址经纬度，例如：31.2538,121.4185
     */
    private String deliveryGeo;

    /**
     * 顾客送餐详情地址，例如：近铁城市广场（普陀区金沙江路1518弄)
     */
    private String deliveryPoiAddress;

    /**
     * 是否需要发票，0-不需要，1-需要
     */
    private boolean invoiced;

    /**
     * 店铺实收
     */
    private double income;

    /**
     * 饿了么服务费率
     */
    private double serviceRate;

    /**
     * 饿了么服务费
     */
    private double serviceFee;

    /**
     * 订单中红包金额
     */
    private double hongbao;

    /**
     * 餐盒费
     */
    private double packageFee;

    /**
     * 订单活动总额
     */
    private double activityTotal;

    /**
     * 店铺承担活动费用
     */
    private double shopPart;

    /**
     * 饿了么承担活动费用
     */
    private double elemePart;

    /**
     * 降级标识
     */
    private boolean downgraded;
}
