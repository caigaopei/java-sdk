package me.ele.shop.sdk.interfaces.exception;


public class AccessDeniedException extends ServiceException {
    public AccessDeniedException() {
        super("ACCESS_DENIED", "拒绝访问");
    }
    public AccessDeniedException(String message) {
        super("ACCESS_DENIED", message);
    }
}
