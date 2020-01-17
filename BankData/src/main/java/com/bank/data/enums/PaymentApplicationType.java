package com.bank.data.enums;

public enum PaymentApplicationType {
    Debit(1),
    Credit(2),
    Loan(3),
    Corporation(4),
    Deposit(5),
    Gift(6),
    Bonus(7);

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
