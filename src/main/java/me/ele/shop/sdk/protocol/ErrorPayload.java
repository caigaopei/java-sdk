package me.ele.shop.sdk.protocol;

import lombok.Data;

@Data
public class ErrorPayload {
    private String code;
    private String message;
}