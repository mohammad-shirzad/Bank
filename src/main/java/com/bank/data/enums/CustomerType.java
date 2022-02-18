package com.bank.data.enums;

public enum CustomerType {

    REAL('R'),
    CORPORATION('C'),
    TRANSITIVE('T');

    private Character value;

    public Character getValue() {
        return value;
    }

    CustomerType(Character value) {
        this.value = value;
    }

}
