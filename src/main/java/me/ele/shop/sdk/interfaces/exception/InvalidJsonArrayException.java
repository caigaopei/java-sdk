package me.ele.shop.sdk.interfaces.exception;

public class InvalidJsonArrayException extends ServiceException {

    public InvalidJsonArrayException(String property) {
        super("INVALID_JSON_ARRAY", property + "不是一个有效的JSON数组");
    }
}
