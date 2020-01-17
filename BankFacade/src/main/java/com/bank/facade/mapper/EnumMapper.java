package com.bank.facade.mapper;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;
import com.bank.data.enums.PaymentApplicationType;
import com.bank.facade.dto.CustomerTypeDto;
import com.bank.facade.dto.IdentityTypeDto;
import com.bank.facade.dto.PaymentApplicationTypeDto;

public class EnumMapper {
    public static CustomerType toCustomerType(CustomerTypeDto customerTypeDto) {
        if (customerTypeDto == null)
            return null;

        switch (customerTypeDto) {
            case Real:
                return CustomerType.Real;
            case Transitive:
                return CustomerType.Transitive;
            case Corporation:
                return CustomerType.Corporation;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static CustomerTypeDto toCustomerTypeDto(CustomerType customerType) {
        if (customerType == null)
            return null;

        switch (customerType) {
            case Real:
                return CustomerTypeDto.Real;
            case Transitive:
                return CustomerTypeDto.Transitive;
            case Corporation:
                return CustomerTypeDto.Corporation;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static IdentityType toIdentityType(IdentityTypeDto identityTypeDto) {
        if (identityTypeDto == null)
            return null;

        switch (identityTypeDto) {
            case NationalId:
                return IdentityType.NationalId;
            case RefugeeNumber:
                return IdentityType.RefugeeNumber;
            case PassportNumber:
                return IdentityType.PassportNumber;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static IdentityTypeDto toIdentityTypeDto(IdentityType identityType) {
        if (identityType == null)
            return null;

        switch (identityType) {
            case NationalId:
                return IdentityTypeDto.NationalId;
            case RefugeeNumber:
                return IdentityTypeDto.RefugeeNumber;
            case PassportNumber:
                return IdentityTypeDto.PassportNumber;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static PaymentApplicationType toPaymentApplicationType(PaymentApplicationTypeDto paymentApplicationTypeDto) {
        if (paymentApplicationTypeDto == null)
            return null;

        switch (paymentApplicationTypeDto) {
            case Debit:
                return PaymentApplicationType.Debit;
            case Credit:
                return PaymentApplicationType.Credit;
            case Corporation:
                return PaymentApplicationType.Corporation;
            case Bonus:
                return PaymentApplicationType.Bonus;
            case Gift:
                return PaymentApplicationType.Gift;
            case Loan:
                return PaymentApplicationType.Loan;
            case Deposit:
                return PaymentApplicationType.Deposit;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static PaymentApplicationTypeDto toPaymentApplicationTypeDto(PaymentApplicationType paymentApplicationType) {
        if (paymentApplicationType == null)
            return null;

        switch (paymentApplicationType) {
            case Debit:
                return PaymentApplicationTypeDto.Debit;
            case Credit:
                return PaymentApplicationTypeDto.Credit;
            case Corporation:
                return PaymentApplicationTypeDto.Corporation;
            case Bonus:
                return PaymentApplicationTypeDto.Bonus;
            case Gift:
                return PaymentApplicationTypeDto.Gift;
            case Loan:
                return PaymentApplicationTypeDto.Loan;
            case Deposit:
                return PaymentApplicationTypeDto.Deposit;
            default:
                throw new IllegalArgumentException();
        }
    }
}
