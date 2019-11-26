package com.bank.facade.response;

import com.bank.data.entity.*;

import java.util.List;

public class FindCustomerResponse {
    private List<ECustomer> eCustomer;

    public List<ECustomer> geteCustomer() {
        return eCustomer;
    }

    public void seteCustomer(List<ECustomer> eCustomer) {
        this.eCustomer = eCustomer;
    }
}
