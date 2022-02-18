package com.bank.data.exception;

public class BusinessRuntimeException extends RuntimeException {
    public BusinessRuntimeException() {
        super();
    }

    public BusinessRuntimeException(String msg) {
        super(msg);
    }
}
