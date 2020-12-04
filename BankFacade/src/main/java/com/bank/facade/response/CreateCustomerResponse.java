package com.bank.facade.response;

import com.bank.data.entity.EContact;

public class CreateCustomerResponse {
    private EContact eContact;

    public EContact geteContact() {
        return eContact;
    }

    public void seteContact(EContact eContact) {
        this.eContact = eContact;
    }
}
