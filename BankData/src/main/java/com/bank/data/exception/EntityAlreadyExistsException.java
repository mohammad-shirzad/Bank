package com.bank.data.exception;

public class EntityAlreadyExistsException extends BusinessException {
    public EntityAlreadyExistsException() {
        super();
    }

    public EntityAlreadyExistsException(String msg) {
        super(msg);
    }
}
