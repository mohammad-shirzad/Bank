package com.bank.data.filter;

import com.bank.data.enums.CustomerType;
import com.bank.data.enums.IdentityType;

public class EfCustomer {
    private String IdentityNo;
    private String CustomerNo;

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
}
