package me.ele.shop.sdk.interfaces.exception;


public class ServiceIOException extends ServiceException {
    public ServiceIOException(String message) {
        super("FAIL_SERVICE_IO", message);
    }
}
