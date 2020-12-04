package com.bank.facade.dto;

import com.bank.data.enums.PaymentApplicationType;

public enum PaymentApplicationTypeDto {
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
