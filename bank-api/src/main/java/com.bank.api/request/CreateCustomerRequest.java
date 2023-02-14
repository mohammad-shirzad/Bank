package com.bank.api.request;

import com.bank.controller.dto.entity.AddressDto;
import com.bank.controller.dto.enumeration.CustomerTypeDto;
import com.bank.controller.dto.enumeration.IdentityTypeDto;

import java.util.Date;

public class CreateCustomerRequest extends ServiceRequest {


    private String firstName;

    private String lastName;

    private String identityNo;

    private CustomerTypeDto customerType;

    private IdentityTypeDto identityType;
    private String customerNo;
    private Date dateOfBirth;
    private AddressDto address;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CreateCustomerRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentityNo='" + identityNo + '\'' +
                ", customerType=" + customerType +
                ", identityType=" + identityType +
                ", customerNo='" + customerNo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                "} " + super.toString();
    }
}
