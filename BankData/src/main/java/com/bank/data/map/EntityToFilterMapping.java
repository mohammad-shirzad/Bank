package com.bank.data.map;

import com.bank.data.filter.*;
import com.bank.data.entity.*;

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
