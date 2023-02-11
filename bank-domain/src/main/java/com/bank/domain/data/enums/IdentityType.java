package com.bank.domain.data.enums;

public enum IdentityType {
    NATIONAL_ID('N'),
    PASSPORT_NO('P'),
    REFUGEE_NO('R');

    private Character value;

    public Character getValue() {
        return value;
    }

    IdentityType(Character value) {
        this.value = value;
    }
}
