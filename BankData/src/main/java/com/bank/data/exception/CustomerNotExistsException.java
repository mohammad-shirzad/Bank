package com.bank.data.exception;

public class CustomerNotExistsException extends BusinessException {
    public CustomerNotExistsException() {
        super();
    }

    public CustomerNotExistsException(String msg) {
        super(msg);
    }
}
