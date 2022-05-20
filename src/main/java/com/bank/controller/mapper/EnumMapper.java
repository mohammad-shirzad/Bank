package com.bank.controller.mapper;

import com.bank.controller.dto.enumeration.CustomerTypeDto;
import com.bank.controller.dto.enumeration.IdentityTypeDto;
import com.bank.controller.dto.enumeration.PaymentApplicationTypeDto;
import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;
import com.bank.data.enums.PaymentApplicationType;

public class EnumMapper {
    public static CustomerType toCustomerType(CustomerTypeDto customerTypeDto) {
        if (customerTypeDto == null)
            return null;

        switch (customerTypeDto) {
            case REAL:
                return CustomerType.REAL;
            case CORPORATION:
                return CustomerType.CORPORATION;
            case TRANSITIVE:
                return CustomerType.TRANSITIVE;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static CustomerTypeDto toCustomerTypeDto(CustomerType customerType) {
        if (customerType == null)
            return null;

        switch (customerType) {
            case REAL:
                return CustomerTypeDto.REAL;
            case CORPORATION:
                return CustomerTypeDto.CORPORATION;
            case TRANSITIVE:
                return CustomerTypeDto.TRANSITIVE;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static IdentityType toIdentityType(IdentityTypeDto identityTypeDto) {
        if (identityTypeDto == null)
            return null;

        switch (identityTypeDto) {
            case NATIONAL_ID:
                return IdentityType.NATIONAL_ID;
            case REFUGEE_NO:
                return IdentityType.REFUGEE_NO;
            case PASSPORT_NO:
                return IdentityType.PASSPORT_NO;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static IdentityTypeDto toIdentityTypeDto(IdentityType identityType) {
        if (identityType == null)
            return null;

        switch (identityType) {
            case NATIONAL_ID:
                return IdentityTypeDto.NATIONAL_ID;
            case REFUGEE_NO:
                return IdentityTypeDto.REFUGEE_NO;
            case PASSPORT_NO:
                return IdentityTypeDto.PASSPORT_NO;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static PaymentApplicationType toPaymentApplicationType(PaymentApplicationTypeDto paymentApplicationTypeDto) {
        if (paymentApplicationTypeDto == null)
            return null;

        switch (paymentApplicationTypeDto) {
            case DEBIT:
                return PaymentApplicationType.DEBIT;
            case CREDIT:
                return PaymentApplicationType.CREDIT;
            case CORPORATION:
                return PaymentApplicationType.CORPORATION;
            case BONUS:
                return PaymentApplicationType.BONUS;
            case GIFT:
                return PaymentApplicationType.GIFT;
            case LOAN:
                return PaymentApplicationType.LOAN;
            case DEPOSIT:
                return PaymentApplicationType.DEPOSIT;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static PaymentApplicationTypeDto toPaymentApplicationTypeDto(PaymentApplicationType paymentApplicationType) {
        if (paymentApplicationType == null)
            return null;

        switch (paymentApplicationType) {
            case DEBIT:
                return PaymentApplicationTypeDto.DEBIT;
            case CREDIT:
                return PaymentApplicationTypeDto.CREDIT;
            case CORPORATION:
                return PaymentApplicationTypeDto.CORPORATION;
            case BONUS:
                return PaymentApplicationTypeDto.BONUS;
            case GIFT:
                return PaymentApplicationTypeDto.GIFT;
            case LOAN:
                return PaymentApplicationTypeDto.LOAN;
            case DEPOSIT:
                return PaymentApplicationTypeDto.DEPOSIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
