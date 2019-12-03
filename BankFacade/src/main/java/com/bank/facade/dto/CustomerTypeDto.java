package com.bank.facade.dto;

public enum CustomerTypeDto {
    Real('R'),
    Corporation('C'),
    Transitive('T');

    private char value;

    public char getValue() {
        return value;
    }

    CustomerTypeDto(char value) {
        this.value = value;
    }

    public static CustomerTypeDto fromValue(Character c) {
        if (c == null)
            return null;
        for (CustomerTypeDto ct : CustomerTypeDto.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
