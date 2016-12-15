package me.ele.shop.sdk.interfaces.exception;


public class UnauthorizedException extends ServiceException {
    public UnauthorizedException() {
        super("UNAUTHORIZED", "token认证失败,请重新申请token");
    }
}
