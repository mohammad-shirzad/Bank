package com.bank.data.exception;

public class CustomerAlreadyExistsException extends BusinessException {
    public CustomerAlreadyExistsException() {
        super();
    }

    public CustomerAlreadyExistsException(String msg) {
        super(msg);
    }
}
