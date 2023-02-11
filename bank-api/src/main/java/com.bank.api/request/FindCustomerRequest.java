package com.bank.controller.request;

import com.bank.controller.dto.filter.CustomerFilterDto;

public class FindCustomerRequest extends ServiceRequest{
    private CustomerFilterDto customerFilterDto;

    public CustomerFilterDto getCustomerFilterDto() {
        return customerFilterDto;
    }

    public void setCustomerFilterDto(CustomerFilterDto customerFilterDto) {
        this.customerFilterDto = customerFilterDto;
    }

    @Override
    public String toString() {
        return "FindCustomerRequest{" +
                "customerFilterDto=" + customerFilterDto +
                "} " + super.toString();
    }
}
