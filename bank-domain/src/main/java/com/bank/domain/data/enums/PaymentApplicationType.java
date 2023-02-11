package com.bank.domain.data.enums;

public enum PaymentApplicationType {
    DEBIT(1),
    CREDIT(2),
    LOAN(3),
    CORPORATION(4),
    DEPOSIT(5),
    GIFT(6),
    BONUS(7);

    private Integer value;

    public Integer getValue() {
        return value;
    }

    PaymentApplicationType(Integer value) {
        this.value = value;
    }

    public static PaymentApplicationType fromValue(Integer c) {
        if (c == null)
            return null;
        for (PaymentApplicationType ct : PaymentApplicationType.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
