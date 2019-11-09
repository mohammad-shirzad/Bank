package com.bank.data.enums;

public enum IdentityType {
    NationalId('N'),
    PassportNumber('P'),
    RefugeeNumber('R');

    private char value;

    public char getValue() {
        return value;
    }

    IdentityType(char value) {
        this.value = value;
    }

    public static IdentityType fromValue(Character c) {
        if (c == null)
            return null;
        for (IdentityType ct : IdentityType.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
