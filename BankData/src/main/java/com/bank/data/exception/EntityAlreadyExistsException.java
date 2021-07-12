package com.bank.data.exception;

public class EntityAlreadyExistsException extends BusinessException {
    private String entityName;

    public EntityAlreadyExistsException(String msg, String entityName) {
        super(msg);
        this.entityName = entityName;
    }

    public EntityAlreadyExistsException() {
        super();
    }

    public EntityAlreadyExistsException(String msg) {
        super(msg);
    }
}
