package com.bank.domain.data.enums;

public enum CustomerType {
    REAL('R'),
    CORPORATION('C'),
    TRANSITIVE('T');

    private char value;

    CustomerType(char value) {
        this.value = value;
    }

    public static CustomerType fromValue(Character c) {
        if (c == null)
            return null;
        for (CustomerType ct : CustomerType.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }

    public char getValue() {
        return value;
    }
}
