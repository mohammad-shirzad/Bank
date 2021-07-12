package com.bank.exporter.mapper;

import com.bank.data.entity.EAddress;
import com.bank.data.entity.ECard;
import com.bank.data.entity.EContact;
import com.bank.data.filter.EfContact;
import com.bank.data.view.EVCustomer;
import com.bank.exporter.dto.entity.AddressDto;
import com.bank.exporter.dto.filter.CustomerFilterDto;
import com.bank.exporter.request.IssueCardRequest;
import com.bank.exporter.request.UpdateCustomerRequest;
import com.bank.exporter.response.IssueCardResponse;

import java.util.ArrayList;
import java.util.List;

public class EntityMapper {
    public static EfContact toEfCustomer(CustomerFilterDto customerFilterDto) {
        if (customerFilterDto == null)
            return null;
        EfContact efContact = new EfContact();
        efContact.setCustomerNo(customerFilterDto.getCustomerNo());
        efContact.setIdentityNo(customerFilterDto.getIdentityNo());

        return efContact;
    }

    public static EContact toECustomer(UpdateCustomerRequest request) {
        if (request == null)
            return null;

        EContact customer = new EContact();
        customer.setIdentityNo(request.getIdentityNo());
        customer.setAddress(toEAddress(request.getAddress()));
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());

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

    public static ECard toECard(IssueCardRequest request) {
        if (request == null)
            return null;

        ECard card = new ECard();
        card.setOwnerCustomerNo(request.getOwnerCustomerNo());

        return card;
    }

    public static IssueCardResponse toIssueCardResponse(ECard card) {
        if (card == null)
            return null;

        IssueCardResponse response = new IssueCardResponse();
        response.setCarNo(card.getCardNo());
        response.setExpireDate(card.getExpireDate());
        response.setIssueDate(card.getIssueDate());
        response.setOwnerCustomerNo(card.getOwnerCustomerNo());
        response.setHolderId(String.valueOf(card.getHolderId()));
        response.setPin1(card.getPin1());
        response.setPin2(card.getPin2());
        response.setPaymentApplicationTypeDto(EnumMapper.toPaymentApplicationTypeDto(card.getPaymentApplicationType()));
        response.setFirstName(card.getCustomer().getFirstName());
        response.setLastName(card.getCustomer().getLastName());

        return response;
    }

    public static List<EVCustomer> toEvCustomer(List<EContact> customers) {
        if (customers.isEmpty())
            return new ArrayList<>();

        List<EVCustomer> evCustomers = new ArrayList<>();

        for (EContact customer : customers) {
            EVCustomer evCustomer = new EVCustomer();
            evCustomer.setHolderId(customer.getId());
            evCustomer.setAddress(customer.getAddress());
            evCustomer.setFirstName(customer.getFirstName());
            evCustomer.setLastName(customer.getLastName());
            evCustomer.setIdentityNo(customer.getIdentityNo());
            evCustomer.setCustomerNo(customer.getCustomerNo());
            evCustomer.setCustomerType(customer.getCustomerType());
            evCustomer.setIdentityType(customer.getIdentityType());
            evCustomer.setDateOfBirth(customer.getDateOfBirth());

            evCustomers.add(evCustomer);
        }

        return evCustomers;
    }
}
