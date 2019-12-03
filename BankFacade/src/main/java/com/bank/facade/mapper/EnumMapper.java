package com.bank.facade.mapper;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;
import com.bank.facade.dto.CustomerTypeDto;
import com.bank.facade.dto.IdentityTypeDto;

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
}
