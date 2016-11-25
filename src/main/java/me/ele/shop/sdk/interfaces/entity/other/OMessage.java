package me.ele.shop.sdk.interfaces.entity.other;

import lombok.Data;

@Data
public class OMessage {
    private String request_id;
    private int type;
    private String message;
    private int shop_id;
    private long timestamp;
    private String signature;
}
