package com.bank.domain.business.card;

import com.bank.domain.data.enums.PaymentApplicationType;

public class CardBusiness {
    public static boolean supportNoName(PaymentApplicationType paymentApplicationType) {
        switch (paymentApplicationType) {
            case BONUS:
            case GIFT:
                return true;
            case LOAN:
            case DEBIT:
            case CREDIT:
            case DEPOSIT:
            case CORPORATION:
                return false;
            default:
                throw new IllegalArgumentException("Payment application type " + paymentApplicationType + "does not exists");
        }
    }
}
