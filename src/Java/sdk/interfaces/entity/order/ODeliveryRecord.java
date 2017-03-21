package sdk.interfaces.entity.order;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import sdk.deserializer.DateDeserializer;
import sdk.interfaces.enumeration.order.OState;
import sdk.interfaces.enumeration.order.OSubState;

import java.util.Date;

/**
 * 运单记录
 */
public class ODeliveryRecord {
    /**
     * String 订单Id||"100027455049038461"
     */
    private String orderId;
    /**
     * OState 运单主状态||"cancelled"
     */
    private OState state;
    /**
     * OSubState 运单子状态||"systemReason"
     */
    private OSubState subState;
    /**
     * String 配送员姓名||"王小明"
     */
    private String deliverName;
    /**
     * String 配送员手机号||"15000888888"
     */
    private String deliverPhone;
    /**
     * String 记录创建时间||"2016-11-30T12:15:53"
     */
    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OState getState() {
        return state;
    }

    public void setState(OState state) {
        this.state = state;
    }

    public OSubState getSubState() {
        return subState;
    }

    public void setSubState(OSubState subState) {
        this.subState = subState;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public void setDeliverName(String deliverName) {
        this.deliverName = deliverName;
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }

    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
