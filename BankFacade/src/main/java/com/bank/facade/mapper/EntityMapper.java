package com.bank.facade.mapper;

import com.bank.data.entity.EAddress;
import com.bank.data.entity.ECustomer;
import com.bank.data.filter.EfCustomer;
import com.bank.facade.dto.AddressDto;
import com.bank.facade.dto.CustomerFilterDto;
import com.bank.facade.request.UpdateCustomerRequest;

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

    public static ECustomer toECustomer(UpdateCustomerRequest request) {
        if (request == null)
            return null;

        ECustomer customer = new ECustomer();
        customer.setIdentityNo(request.getIdentityNo());
        customer.setIdentityType(request.getIdentityType());
        customer.setCustomerNo(request.getCustomerNo());
        customer.setDateOfBirth(request.getDateOfBirth());
        customer.setAddress(toEAddress(request.getAddress()));
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setCustomerType(request.getCustomerType());

        return customer;
    }

    public static EAddress toEAddress(AddressDto dto) {
        if (dto == null)
            return null;

        EAddress address = new EAddress();
        address.setAlley(dto.getAlley());
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setNumber(dto.getNumber());
        address.setProvince(dto.getProvince());

        return address;
    }
}
