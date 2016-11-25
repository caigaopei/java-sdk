package me.ele.shop.sdk.interfaces.exception;

public class BusinessException extends ServiceException {
    public BusinessException() {
        super("BIZ_EXCEPTION", "业务异常，请检查业务流程是否正确");
    }
    public BusinessException(String message) {
        super("BIZ_EXCEPTION", message);
    }

    public BusinessException(String code, String message) {
        super(code, message);
    }

    public BusinessException(ServiceException e) {
        super("BIZ_" + e.getCode(), e.getMessage());
    }
}
