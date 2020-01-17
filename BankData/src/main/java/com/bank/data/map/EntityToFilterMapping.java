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

        return efCustomer;
    }
}
