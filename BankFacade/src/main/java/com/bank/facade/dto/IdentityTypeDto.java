package com.bank.facade.dto;

public enum IdentityTypeDto {
    NationalId('N'),
    PassportNumber('P'),
    RefugeeNumber('R');

    private char value;

    public char getValue() {
        return value;
    }

    IdentityTypeDto(char value) {
        this.value = value;
    }

    public static IdentityTypeDto fromValue(Character c) {
        if (c == null)
            return null;
        for (IdentityTypeDto ct : IdentityTypeDto.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
