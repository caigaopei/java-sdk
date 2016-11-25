package me.ele.shop.sdk.protocol;

import lombok.Data;

@Data
public class ResponsePayload {
    /**
     * Request id
     */
    private String id;

    /**
     * Invocation result
     */
    private Object result;

    /**
     * Invocation error
     */
    private ErrorPayload error;
}