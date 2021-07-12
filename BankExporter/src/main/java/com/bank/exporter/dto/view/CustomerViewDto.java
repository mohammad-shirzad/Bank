package com.bank.exporter.dto.view;

import com.bank.data.entity.EAddress;
import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;

import java.util.Date;

public class CustomerViewDto {
    private Long holderId;

    private String firstName;

    private String lastName;

    private String identityNo;

    private CustomerType customerType;

    private String customerNo;

    private IdentityType identityType;

    private Date dateOfBirth;

    private EAddress address;

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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EAddress getAddress() {
        return address;
    }

    public void setAddress(EAddress address) {
        this.address = address;
    }
}
