package com.bank.data.exception;

public class RequiredArgumentException extends BusinessRuntimeException {
    public RequiredArgumentException() {
        super();
    }

    public RequiredArgumentException(String msg) {
        super(msg);
    }
}
