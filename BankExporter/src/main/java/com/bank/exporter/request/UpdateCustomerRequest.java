package com.bank.exporter.request;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;
import com.bank.exporter.dto.entity.AddressDto;
import com.bank.exporter.dto.enumeration.CustomerTypeDto;
import com.bank.exporter.dto.enumeration.IdentityTypeDto;

public class UpdateCustomerRequest extends ServiceRequest{
    private String firstName;

    private String lastName;

    private String IdentityNo;

    private CustomerTypeDto customerType;

    private IdentityTypeDto identityType;

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

    @Override
    public String toString() {
        return "UpdateCustomerRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdentityNo='" + IdentityNo + '\'' +
                ", customerType=" + customerType +
                ", identityType=" + identityType +
                ", address=" + address +
                "} " + super.toString();
    }
}
