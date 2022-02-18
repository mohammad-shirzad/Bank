package com.bank.util;

import com.bank.controller.request.CreateCustomerRequest;
import com.bank.data.entity.EContact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectMapper {
    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);
    EContact toEContact(CreateCustomerRequest request);
}
