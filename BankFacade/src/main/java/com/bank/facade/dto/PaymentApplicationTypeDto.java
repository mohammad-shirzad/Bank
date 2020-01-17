package com.bank.facade.dto;

import com.bank.data.enums.PaymentApplicationType;

public enum PaymentApplicationTypeDto {
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

    PaymentApplicationTypeDto(Integer value) {
        this.value = value;
    }

    public static PaymentApplicationTypeDto fromValue(Integer c) {
        if (c == null)
            return null;
        for (PaymentApplicationTypeDto ct : PaymentApplicationTypeDto.values()) {
            if (c.equals(ct.getValue()))
                return ct;
        }
        throw new IllegalArgumentException();
    }
}
