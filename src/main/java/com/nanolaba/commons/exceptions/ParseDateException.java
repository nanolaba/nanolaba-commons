package com.nanolaba.commons.exceptions;

public class ParseDateException extends RuntimeException {

    public ParseDateException() {
    }

    public ParseDateException(String message) {
        super(message);
    }

    public ParseDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseDateException(Throwable cause) {
        super(cause);
    }

    public ParseDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
