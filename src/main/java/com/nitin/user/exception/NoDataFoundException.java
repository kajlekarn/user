package com.nitin.user.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException() {
        super("NO DATA FOUND EXCEPTION");
    }
}
