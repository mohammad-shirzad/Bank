package com.bank.domain.data.map;

import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.filter.EfContact;

public class EntityToFilterMapping {
    public static EfContact mapToEfCustomer(EContact eContact) {
        if (eContact == null)
            return null;

        EfContact efContact = new EfContact();
        efContact.setCustomerNo(eContact.getCustomerNo());
        efContact.setIdentityNo(eContact.getIdentityNo());

        return efContact;
    }
}
