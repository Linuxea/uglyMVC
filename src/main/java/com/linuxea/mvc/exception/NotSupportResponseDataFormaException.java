package com.linuxea.mvc.exception;

/**
 * @author linuxea
 * @date 17-11-27
 **/
public class NotSupportResponseDataFormaException extends BaseException {

    public NotSupportResponseDataFormaException() {
        super();
    }

    public NotSupportResponseDataFormaException(String message) {
        super(message);
    }

    public NotSupportResponseDataFormaException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportResponseDataFormaException(Throwable cause) {
        super(cause);
    }

    protected NotSupportResponseDataFormaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
