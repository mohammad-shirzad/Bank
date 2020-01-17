package com.bank.facade.request;

import com.bank.data.entity.ECustomer;
import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;
import com.bank.facade.dto.AddressDto;

import java.util.Date;

public class UpdateCustomerRequest {
    private String firstName;

    private String lastName;

    private String IdentityNo;

    private CustomerType customerType;

    private IdentityType identityType;

    private AddressDto address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNo() {
        return IdentityNo;
    }

    public void setIdentityNo(String identityNo) {
        IdentityNo = identityNo;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
