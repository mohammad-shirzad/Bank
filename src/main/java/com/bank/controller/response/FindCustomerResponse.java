package com.bank.controller.response;

import com.bank.controller.dto.view.CustomerViewDto;

import java.util.List;

public class FindCustomerResponse extends ServiceResponse{
    private List<CustomerViewDto> customerViewDtoList;

    public FindCustomerResponse(List<CustomerViewDto> customerViewDtoList) {
        this.customerViewDtoList = customerViewDtoList;
    }

    @Override
    public String toString() {
        return "FindCustomerResponse{" +
                "customerViewDtoList=" + customerViewDtoList +
                "} " + super.toString();
    }
}
