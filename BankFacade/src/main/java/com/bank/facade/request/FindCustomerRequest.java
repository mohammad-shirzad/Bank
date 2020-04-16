package com.bank.facade.request;

import com.bank.data.filter.*;
import com.bank.facade.dto.CustomerFilterDto;

import java.io.Serializable;

public class FindCustomerRequest {
    private CustomerFilterDto customerFilterDto;

    public CustomerFilterDto getCustomerFilterDto() {
        return customerFilterDto;
    }

    public void setCustomerFilterDto(CustomerFilterDto customerFilterDto) {
        this.customerFilterDto = customerFilterDto;
    }
}
