package sdk.interfaces.entity.item;

/**
 * 时间段
 */
public class OItemTime {

    /**
     * 售卖开始时间，格式：HH:mm|必选|"18:02"
     */
    private String beginTime;

    /**
     * 售卖结束时间，格式：HH:mm|必选|"19:02"
     */
    private String endTime;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
