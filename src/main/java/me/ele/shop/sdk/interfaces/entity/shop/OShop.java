package me.ele.shop.sdk.interfaces.entity.shop;

import lombok.Data;
import me.ele.shop.sdk.interfaces.enumeration.shop.OBusyLevel;

import java.util.List;

@Data
public class OShop {

    /**
     * 店铺地址
     */
    private String addressText;

    /**
     * 店铺默认配送费
     */
    private Short agentFee;

    /**
     * 店铺营业状态
     */
    private OBusyLevel busyLevel;

    /**
     * 城市区号(021, 010等)
     */
    private String cityCode;

    /**
     * 城市id
     */
    private int cityId;

    /**
     * 营业时间bitmap
     *
     * @desc bitmap说明
     * @demo open_time_bitmap/book_time_bitmap（营业时间/预定时间）是一个字符串，在判断餐厅是否营业/可预订的时候，将当前的小时h以及当前的分钟m计算出index:
     * ```index = now.hour * 12 + now.minute / 5```
     * 然后在open_time_bitmap/book_time_bitmap这个string中取第index个字符，如果是1则餐厅营业/可预订，否则不营业/不可预订:
     * ```is_open = int(open_time_bitmap[now.hour * 12 + now.minute / 5])```
     */
    private String openTimeBitmap;

    /**
     * 预定时间bitmap
     *
     * @desc bitmap说明
     * @demo open_time_bitmap/book_time_bitmap（营业时间/预定时间）是一个字符串，在判断餐厅是否营业/可预订的时候，将当前的小时h以及当前的分钟m计算出index:
     * ```index = now.hour * 12 + now.minute / 5```
     * 然后在open_time_bitmap/book_time_bitmap这个string中取第index个字符，如果是1则餐厅营业/可预订，否则不营业/不可预订:
     * ```is_open = int(open_time_bitmap[now.hour * 12 + now.minute / 5])```
     */
    private String bookTimeBitmap;

    /**
     * 是否支持预定(n=0表示不支持预定,7>n>=1表示支持n天内的预定）
     *
     * @desc 预订单说明
     * @demo 餐厅的状态可以参考 餐厅营业状态，当餐厅是营业状态的时候，有以下几种情况：
     * #####当前时间在营业时间内
     * - 餐厅is_bookable=1（可以预定），则用户下单时可以选择立即送（deliver_time不传），也可以定时送（预订单），但是定时的选项要从餐厅的deliver_times里选择一个
     * - 餐厅is_bookable=0（不可以预定），则用户只能选择立即送
     * <p>
     * #####当前时间不在营业时间内
     * - 餐厅is_bookable=1，则用户可以下预订单，预订单的选项从deliver_times里选择一个
     * - 餐厅is_bookable=0，则用户不可以下单，显示餐厅休息中
     */
    private int isBookable;

    /**
     * 营业时间
     */
    private List<String> servingTime;

    /**
     * 预定时间选项
     */
    private List<String> deliverTimes;

    /**
     * 店铺关闭的原因
     */
    private String closeDescription;

    /**
     * 2周内的平均送餐时间
     */
    private int deliverSpent;

    /**
     * 店铺描述
     */
    private String description;

    /**
     * 店铺口味
     */
    private String flavors;

    /**
     * 是否支持开发票(是为1，否为0)
     */
    private int invoice;

    /**
     * 支持的最小发票金额
     */
    private double invoiceMinAmount;

    /**
     * 是否隐藏电话号码
     */
    private int isPhoneHidden;

    /**
     * 是否支持超时赔付(是为1，否为0)
     */
    private int isTimeEnsure;

    /**
     * 店铺地址坐标-纬度
     */
    private double latitude;

    /**
     * 店铺地址坐标-经度
     */
    private double longitude;

    /**
     * 店铺接收饿了么短信的手机号码
     */
    private String mobile;

    /**
     * 免配送费的最低消费额度
     */
    private double noAgentFeeTotal;

    /**
     * 店铺评价，依次为1-5星评价的数目
     */
    private List<Short> numRatings;

    /**
     * 是否支持在线支付(是为1，否为0)
     */
    private int onlinePayment;

    /**
     * 是否正在营业(是为1，否为0)
     */
    private boolean isOpen;

    /**
     * 店铺的联系电话
     */
    private List<String> phones;

    /**
     * 店铺促销文案信息
     */
    private String promotionInfo;

    /**
     * 最近一个月美食销量
     */
    private int recentFoodPopularity;

    /**
     * 店铺id
     */
    private int id;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 是否支持在线订餐
     */
    private boolean supportOnline;

    /**
     * 超时赔付详细信息
     */
    private String timeEnsureFullDescription;

    /**
     * 店铺Logo地址
     */
    private String imageUrl;

    /**
     * 店铺手机站url
     */
    private String mUrl;
}
