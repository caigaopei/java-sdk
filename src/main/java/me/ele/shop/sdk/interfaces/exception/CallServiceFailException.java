package me.ele.shop.sdk.interfaces.exception;

public class CallServiceFailException extends ServiceException {
    public CallServiceFailException(String message) {
        super("CALL_SERVICE_FAIL", message);
    }
}
