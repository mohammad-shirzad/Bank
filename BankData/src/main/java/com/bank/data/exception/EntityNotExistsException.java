package com.bank.data.exception;

public class EntityNotExistsException extends BusinessException {
    public EntityNotExistsException() {
        super();
    }

    public EntityNotExistsException(String msg) {
        super(msg);
    }
}
