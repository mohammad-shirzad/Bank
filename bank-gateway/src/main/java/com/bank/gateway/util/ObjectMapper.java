package com.bank.gateway.util;

import com.bank.api.dto.filter.CustomerFilterDto;
import com.bank.api.dto.view.CardViewDto;
import com.bank.api.request.CreateCustomerRequest;
import com.bank.api.request.IssueCardRequest;
import com.bank.api.request.UpdateCustomerRequest;
import com.bank.api.response.IssueCardResponse;
import com.bank.domain.data.entity.ECard;
import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.filter.EfContact;
import com.bank.domain.data.view.EvCard;
import com.bank.domain.data.view.EvCardIssueDetailData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ObjectMapper {
    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);

    EContact toEContact(CreateCustomerRequest request);

    CardViewDto toCardViewDto(EvCard evCard);

    EvCardIssueDetailData toEvCardIssueDetailData(ECard card);

    EfContact toEfContact(CustomerFilterDto customerFilterDto);

    com.bank.controller.dto.view.CustomerViewDto toCustomerViewDto(EContact eContact);

    EContact toEContact(UpdateCustomerRequest request);

    IssueCardResponse toIssueCardResponse(EvCardIssueDetailData evCardIssueDetailData);

    ECard toECard(IssueCardRequest request);
}
