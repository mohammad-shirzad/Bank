package com.bank.util;

import com.bank.controller.dto.entity.AddressDto;
import com.bank.controller.dto.filter.CustomerFilterDto;
import com.bank.controller.dto.view.CardViewDto;
import com.bank.controller.dto.view.CustomerViewDto;
import com.bank.controller.request.CreateCustomerRequest;
import com.bank.controller.request.IssueCardRequest;
import com.bank.controller.request.UpdateCustomerRequest;
import com.bank.controller.response.IssueCardResponse;
import com.bank.data.entity.EAddress;
import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.filter.EfContact;
import com.bank.data.view.EvCard;
import com.bank.data.view.EvCardIssueDetailData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectMapper {
    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

    EContact toEContact(CreateCustomerRequest request);

    CardViewDto toCardViewDto(EvCard evCard);

    EvCardIssueDetailData toEvCardIssueDetailData(ECard card);

    EfContact toEfContact(CustomerFilterDto customerFilterDto);

    CustomerViewDto toCustomerViewDto(EContact eContact);

    EContact toEContact(UpdateCustomerRequest request);

    IssueCardResponse toIssueCardResponse(EvCardIssueDetailData evCardIssueDetailData);

    ECard toECard(IssueCardRequest request);

    AddressDto toAddressDto(EAddress eAddress);
}