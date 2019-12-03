package com.bank.facade.mapper;

import com.bank.data.filter.EfCustomer;
import com.bank.facade.dto.CustomerFilterDto;

public class EntityMapper {
    public static EfCustomer toEfCustomer(CustomerFilterDto customerFilterDto) {
        if (customerFilterDto == null)
            return null;
        EfCustomer efCustomer = new EfCustomer();
        efCustomer.setCustomerType(EnumMapper.toCustomerType(customerFilterDto.getCustomerTypeDto()));
        efCustomer.setIdentityType(EnumMapper.toIdentityType(customerFilterDto.getIdentityTypeDto()));
        efCustomer.setCustomerNo(customerFilterDto.getCustomerNo());
        efCustomer.setIdentityNo(customerFilterDto.getIdentityNo());

        return efCustomer;
    }
}
