package com.bank.facade.response;

import com.bank.data.entity.ECustomer;

public class CreateCustomerResponse {
    private ECustomer eCustomer;

    public ECustomer geteCustomer() {
        return eCustomer;
    }

    public void seteCustomer(ECustomer eCustomer) {
        this.eCustomer = eCustomer;
    }
}
