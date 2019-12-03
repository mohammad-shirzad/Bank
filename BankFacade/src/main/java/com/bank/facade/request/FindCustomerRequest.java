package com.bank.facade.request;

import com.bank.data.filter.*;
import com.bank.facade.dto.CustomerFilterDto;

public class FindCustomerRequest {
    private CustomerFilterDto customerFilterDto;

    public CustomerFilterDto getCustomerFilterDto() {
        return customerFilterDto;
    }

    public void setCustomerFilterDto(CustomerFilterDto customerFilterDto) {
        this.customerFilterDto = customerFilterDto;
    }
}
