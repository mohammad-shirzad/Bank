package com.bank.controller.dto.view;

import com.bank.controller.dto.entity.AddressDto;
import com.bank.controller.dto.enumeration.CustomerTypeDto;
import com.bank.controller.dto.enumeration.IdentityTypeDto;

import java.util.Date;

public class CustomerViewDto {
    private Long holderId;

    private String firstName;

    private String lastName;

    private String identityNo;

    private CustomerTypeDto customerType;

    private String customerNo;

    private IdentityTypeDto identityType;

    private Date dateOfBirth;

    private AddressDto address;

    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }

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
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CustomerTypeDto getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeDto customerType) {
        this.customerType = customerType;
    }

    public IdentityTypeDto getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityTypeDto identityType) {
        this.identityType = identityType;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
