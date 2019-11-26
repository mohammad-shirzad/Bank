package com.bank.data.map;

import com.bank.data.filter.*;
import com.bank.data.entity.*;

public class EntityToFilterMapping {
    public static EfCustomer mapToEfCustomer(ECustomer eCustomer) {
        if (eCustomer == null)
            return null;

        EfCustomer efCustomer = new EfCustomer();
        efCustomer.setCustomerNo(eCustomer.getCustomerNo());
        efCustomer.setIdentityNo(eCustomer.getIdentityNo());
        efCustomer.setCustomerType(eCustomer.getCustomerType());
        efCustomer.setCustomerTypeValue(eCustomer.getCustomerTypeValue());
        efCustomer.setIdentityType(eCustomer.getIdentityType());
        efCustomer.setIdentityTypeValue(eCustomer.getIdentityTypeValue());

        return efCustomer;
    }
}
