package com.bank.data.enums;

public enum Entity {
    Customer(1),
    Card(2),
    Transaction(3);

    private int value;

    public int getValue() {
        return value;
    }

    Entity(int value) {
        this.value = value;
    }

    public static Entity fromValue(Integer c) {
        if (c == null)
            return null;
        for (Entity ct : Entity.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
