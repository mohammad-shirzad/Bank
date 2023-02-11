package com.bank.domain.data.exception;

public class RequiredArgumentException extends BusinessRuntimeException {
    public RequiredArgumentException() {
        super();
    }

    public RequiredArgumentException(String msg) {
        super(msg);
    }
}
