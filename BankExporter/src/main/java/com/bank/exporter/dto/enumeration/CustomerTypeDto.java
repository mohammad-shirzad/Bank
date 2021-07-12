package com.bank.exporter.dto.enumeration;

public enum CustomerTypeDto {
    REAL('R'),
    CORPORATION('C'),
    TRANSITIVE('T');

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
