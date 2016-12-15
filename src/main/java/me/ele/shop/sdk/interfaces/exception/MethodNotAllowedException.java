package me.ele.shop.sdk.interfaces.exception;

public class MethodNotAllowedException extends ServiceException {
    public MethodNotAllowedException() {
        super("METHOD_NOT_ALLOWED", "禁止访问");
    }
}
