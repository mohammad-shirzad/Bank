package com.bank.data.enums;

public enum Entity {
    CONTACT("Contact"),
    CARD("Card"),
    TRANSACTION("Transaction"),
    ADDRESS("Address");

    private String value;

    public String getValue() {
        return value;
    }

    Entity(String value) {
        this.value = value;
    }

    public static Entity fromValue(String c) {
        if (c == null)
            return null;
        for (Entity ct : Entity.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
