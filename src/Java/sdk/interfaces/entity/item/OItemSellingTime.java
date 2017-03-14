package sdk.interfaces.entity.item;


import sdk.interfaces.enumeration.item.OItemWeekEnum;

import java.util.List;

/**
 * 商品售卖时间
 */
public class OItemSellingTime {

    /**
     * 商品售卖的星期列表|必选|["MONDAY","FRIDAY"]
     */
    private List<OItemWeekEnum> weeks;

    /**
     * 商品售卖的开始日期，格式：yyyy-MM-dd|必选|"2017-03-14"
     */
    private String beginDate;

    /**
     * 商品售卖的结束日期，格式：yyyy-MM-dd|必选|"2017-06-22"
     */
    private String endDate;

    /**
     * 商品售卖时间段，最多可以设置3个|必选|[{"beginTime":"18:02","endTime":"19:02"}]
     */
    private List<OItemTime> times;

    public List<OItemWeekEnum> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<OItemWeekEnum> weeks) {
        this.weeks = weeks;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<OItemTime> getTimes() {
        return times;
    }

    public void setTimes(List<OItemTime> times) {
        this.times = times;
    }
}
