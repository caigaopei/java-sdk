package me.ele.shop.sdk.interfaces.exception;

public class AccessDeniedException extends ServiceException {
    public AccessDeniedException() {
        super("ACCESS_DENIED", "拒绝访问");
    }
}
