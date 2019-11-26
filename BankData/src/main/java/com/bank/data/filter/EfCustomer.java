package com.bank.data.filter;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;

public class EfCustomer {
    private String IdentityNo;
    private String CustomerNo;
    private IdentityType identityType;
    private CustomerType customerType;

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

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Character getIdentityTypeValue() {
        if (identityType == null)
            return null;
        return identityType.getValue();
    }

    public void setIdentityTypeValue(Character identityType) {
        this.identityType = IdentityType.fromValue(identityType);
    }

    public Character getCustomerTypeValue() {
        if (customerType == null)
            return null;
        return customerType.getValue();
    }

    public void setCustomerTypeValue(Character customerType) {
        this.customerType = CustomerType.fromValue(customerType);
    }
}
