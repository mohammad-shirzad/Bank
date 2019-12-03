package com.bank.facade.dto;

public class CustomerFilterDto {
    private String IdentityNo;
    private String CustomerNo;
    private IdentityTypeDto identityTypeDto;
    private CustomerTypeDto customerTypeDto;

    public String getIdentityNo() {
        return IdentityNo;
    }

    public void setIdentityNo(String identityNo) {
        IdentityNo = identityNo;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public IdentityTypeDto getIdentityTypeDto() {
        return identityTypeDto;
    }

    public void setIdentityTypeDto(IdentityTypeDto identityType) {
        this.identityTypeDto = identityType;
    }

    public CustomerTypeDto getCustomerTypeDto() {
        return customerTypeDto;
    }

    public void setCustomerTypeDto(CustomerTypeDto customerType) {
        this.customerTypeDto = customerType;
    }


}
