package com.bank.data.enums;

public enum OperationCode {
    REGISTER_CUSTOMER(((short) 1)),
    UPDATE_CUSTOMER(((short) 2)),
    DELETE_CUSTOMER(((short) 3)),
    ISSUE_CARD(((short) 4));

    private short operationCode;

    OperationCode(short operationCode) {
        this.operationCode = operationCode;
    }

    public short getValue() {
        return operationCode;
    }

    public static OperationCode fromValue(short c) {
        if (c == 0)
            return null;
        for (OperationCode ct : OperationCode.values()) {
            if (c == ct.getValue())
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
