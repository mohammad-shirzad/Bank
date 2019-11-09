package com.bank.data.enums;

public enum CustomerType {

    Real('R'),
    Corporation('C'),
    Transitive('T');

    private char value;

    public char getValue() {
        return value;
    }

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

}
