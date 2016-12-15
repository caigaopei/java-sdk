package me.ele.shop.sdk.interfaces.exception;

public class InvalidJsonException extends ServiceException {

    public InvalidJsonException(String property) {
        super("INVALID_JSON", property + "不是一个有效的JSON对象");
    }

}
