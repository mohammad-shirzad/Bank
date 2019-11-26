package com.bank.facade.request;

import com.bank.data.entity.ECustomer;

public class UpdateCustomerRequest {
    private ECustomer eCustomer;

    public ECustomer geteCustomer() {
        return eCustomer;
    }

    public void seteCustomer(ECustomer eCustomer) {
        this.eCustomer = eCustomer;
    }
}
