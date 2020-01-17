package com.bank.facade.response;

import com.bank.data.entity.*;
import com.bank.data.view.EVCustomer;

import java.util.List;

public class FindCustomerResponse {
    private List<EVCustomer> evCustomer;

    public void setEvCustomer(List<EVCustomer> evCustomer) {
        this.evCustomer = evCustomer;
    }

    public List<EVCustomer> getEvCustomer() {
        return evCustomer;
    }
}
