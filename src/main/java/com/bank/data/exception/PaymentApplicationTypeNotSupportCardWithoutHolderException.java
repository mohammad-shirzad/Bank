package com.bank.data.exception;

public class PaymentApplicationTypeNotSupportCardWithoutHolderException extends BusinessException {
    public PaymentApplicationTypeNotSupportCardWithoutHolderException(String msg) {
        super(msg);
    }
}
