package com.linuxea.mvc.exception;

/**
 * method type not match exception
 * Created by Linuxea on 17-11-25.
 */

public class MethodTypeException extends BaseException {

    public MethodTypeException() {
        super();
    }

    public MethodTypeException(String message) {
        super(message);
    }

    public MethodTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodTypeException(Throwable cause) {
        super(cause);
    }

    protected MethodTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
