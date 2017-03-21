package sdk.interfaces.entity.order;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import sdk.deserializer.DateDeserializer;
import sdk.interfaces.enumeration.order.OOrderRefundStatus;
import sdk.interfaces.enumeration.order.OOrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class OOrder {

    /**
     * String 顾客送餐地址||"近铁城市广场"
     */
    private String address;

    /**
     * String 下单时间||"2016-11-30T12:15:53"
     */
    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt;

    /**
     * String 订单生效时间||"2016-11-30T12:15:53"
     *
     * @desc 即支付时间，只有支付完成后才会推送订单，只有货到付款的订单生效时间等于下单时间
     */
    @JsonDeserialize(using = DateDeserializer.class)
    private Date activeAt;

    /**
     * double 配送费||2.0
     */
    private double deliverFee;

    /**
     * String 预计送达时间||"2016-11-30T13:15:53"
     *
     * @desc 只有预订单的预计送达时间才有意义
     */
    @JsonDeserialize(using = DateDeserializer.class)
    private Date deliverTime;

    /**
     * String 订单备注||"不要香菜"
     */
    private String description;

    /**
     * List<OGoodsGroup> 订单详细类目的列表||[{"items":[{"categoryId":1123123,"id":2341123,"name":"奶茶","price":10.0,"quantity":30,"total":300.0}],"name":"一个分组","type":"discount"}]
     */
    private List<OGoodsGroup> groups = new ArrayList();

    /**
     * String 发票抬头||"拉扎斯网络科技(上海)有限公司"
     */
    private String invoice;

    /**
     * boolean 是否预订单||true
     */
    private boolean book;

    /**
     * boolean 是否在线支付||false
     */
    private boolean onlinePaid;

    /**
     * String 订单Id||"100027455049038461"
     */
    private String id;

    /**
     * List<String> 顾客联系电话||["13507701342"]
     */
    private List<String> phoneList = new ArrayList();

    /**
     * long 店铺Id||968514
     */
    private long shopId;

    /**
     * String 店铺绑定的外部ID||"8389292348123"
     */
    private String openId;

    /**
     * String 店铺名称||"实验餐厅"
     */
    private String shopName;

    /**
     * int 店铺当日订单流水号||89
     */
    private int daySn;

    /**
     * OOrderStatus 订单状态||"settled"
     */
    private OOrderStatus status;

    /**
     * OOrderRefundStatus 退单状态||"noRefund"
     */
    private OOrderRefundStatus refundStatus;

    /**
     * int 下单用户的Id||13524069
     */
    private int userId;

    /**
     * double 订单总价，用户实际支付的金额，单位：元||5.0
     */
    private double totalPrice;

    /**
     * double 订单原始价格||5.0
     *
     * @desc 订单优惠前的价格，即商品总价加上配送费和餐盒费，单位：元
     */
    private double originalPrice;

    /**
     * String 订单收货人姓名||"张三"
     */
    private String consignee;

    /**
     * String 订单收货地址经纬度||"121.83317,31.514559"
     */
    private String deliveryGeo;

    /**
     * String 送餐地址||"近铁城市广场（普陀区金沙江路1518弄)"
     */
    private String deliveryPoiAddress;

    /**
     * boolean 顾客是否需要发票||true
     */
    private boolean invoiced;

    /**
     * double 店铺实收||7.0
     *
     * @desc 店铺实际本单收入，订单总额扣除服务费、商户补贴金额
     */
    private double income;

    /**
     * double 饿了么服务费率||0.0
     */
    private double serviceRate;

    /**
     * double 饿了么服务费||0.0
     */
    private double serviceFee;

    /**
     * double 订单中红包金额||1.0
     */
    private double hongbao;

    /**
     * double 餐盒费||1.0
     */
    private double packageFee;

    /**
     * double 订单活动总额||12.0
     */
    private double activityTotal;

    /**
     * double 店铺承担活动费用||6.0
     */
    private double shopPart;

    /**
     * double 饿了么承担活动费用||6.0
     */
    private double elemePart;

    /**
     * boolean 降级标识||false
     *
     * @desc true为已降级，false为未降级。
     * 平台为尽可能促成交易，会在一部分字段未生成的时候（如活动补贴），将订单生成。
     * 如果需要完整的订单的订单信息，需要事后在降级标记为false时再进行读取。
     * 当此字段为降级标识true的时候会影响本单收入的金额值计算不准确，请开发者务必注意。
     */
    private boolean downgraded;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getActiveAt() {
        return activeAt;
    }

    public void setActiveAt(Date activeAt) {
        this.activeAt = activeAt;
    }

    public double getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(double deliverFee) {
        this.deliverFee = deliverFee;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OGoodsGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<OGoodsGroup> groups) {
        this.groups = groups;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }

    public boolean isOnlinePaid() {
        return onlinePaid;
    }

    public void setOnlinePaid(boolean onlinePaid) {
        this.onlinePaid = onlinePaid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getDaySn() {
        return daySn;
    }

    public void setDaySn(int daySn) {
        this.daySn = daySn;
    }

    public OOrderStatus getStatus() {
        return status;
    }

    public void setStatus(OOrderStatus status) {
        this.status = status;
    }

    public OOrderRefundStatus getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(OOrderRefundStatus refundStatus) {
        this.refundStatus = refundStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getDeliveryGeo() {
        return deliveryGeo;
    }

    public void setDeliveryGeo(String deliveryGeo) {
        this.deliveryGeo = deliveryGeo;
    }

    public String getDeliveryPoiAddress() {
        return deliveryPoiAddress;
    }

    public void setDeliveryPoiAddress(String deliveryPoiAddress) {
        this.deliveryPoiAddress = deliveryPoiAddress;
    }

    public boolean isInvoiced() {
        return invoiced;
    }

    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(double serviceRate) {
        this.serviceRate = serviceRate;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getHongbao() {
        return hongbao;
    }

    public void setHongbao(double hongbao) {
        this.hongbao = hongbao;
    }

    public double getPackageFee() {
        return packageFee;
    }

    public void setPackageFee(double packageFee) {
        this.packageFee = packageFee;
    }

    public double getActivityTotal() {
        return activityTotal;
    }

    public void setActivityTotal(double activityTotal) {
        this.activityTotal = activityTotal;
    }

    public double getShopPart() {
        return shopPart;
    }

    public void setShopPart(double shopPart) {
        this.shopPart = shopPart;
    }

    public double getElemePart() {
        return elemePart;
    }

    public void setElemePart(double elemePart) {
        this.elemePart = elemePart;
    }

    public boolean isDowngraded() {
        return downgraded;
    }

    public void setDowngraded(boolean downgraded) {
        this.downgraded = downgraded;
    }
}
