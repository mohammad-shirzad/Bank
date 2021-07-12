package com.bank.exporter.request;

import com.bank.exporter.dto.filter.CustomerFilterDto;

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
