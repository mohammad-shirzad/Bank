package com.bank.facade.request;

import com.bank.data.filter.*;

public class FindCustomerRequest {
    private EfCustomer efCustomer;

    public EfCustomer getEfCustomer() {
        return efCustomer;
    }

    public void setEfCustomer(EfCustomer efCustomer) {
        this.efCustomer = efCustomer;
    }
}
