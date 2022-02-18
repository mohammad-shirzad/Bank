package com.bank.controller.request;

import com.bank.controller.dto.entity.AddressDto;
import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;

import java.util.Date;

public class CreateCustomerRequest extends ServiceRequest{


    private String firstName;

    private String lastName;

    private String IdentityNo;

    private CustomerType customerType;

    private IdentityType identityType;
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
                ", IdentityNo='" + IdentityNo + '\'' +
                ", customerType=" + customerType +
                ", identityType=" + identityType +
                ", customerNo='" + customerNo + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                "} " + super.toString();
    }
}
