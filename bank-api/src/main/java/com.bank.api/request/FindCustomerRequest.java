package com.bank.api.request;


import com.bank.api.dto.filter.CustomerFilterDto;

public class FindCustomerRequest extends ServiceRequest {
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
