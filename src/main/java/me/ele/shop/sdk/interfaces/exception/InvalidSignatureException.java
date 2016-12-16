package me.ele.shop.sdk.interfaces.exception;

public class InvalidSignatureException extends ServiceException {
    public InvalidSignatureException() {
        super("INVALID_SIGNATURE", "无效的签名");
    }
}
