package com.bank.business.customer;

import com.bank.dao.bean.ContactDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.RequiredArgumentException;
import com.bank.data.filter.EfContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

public class RegisterCustomerBusiness {


    private ContactDao contactDao = DaoFactory.getInstance().getContactDao();

    public void validate(EContact customer) throws EntityAlreadyExistsException {
        if (customer.getIdentityNo() == null && customer.getIdentityNo() == null)
            throw new RequiredArgumentException("Identity number & CustomerNo can not be null");
        EfContact efContact = new EfContact();
        efContact.setIdentityNo(customer.getIdentityNo());
        efContact.setCustomerNo(customer.getCustomerNo());
        List<EContact> dbCustomer = contactDao.find(efContact);
        if (!dbCustomer.isEmpty())
            throw new EntityAlreadyExistsException("customer with identity number " + customer.getIdentityNo() +
                    " was registered before");
    }

    public EContact doBusiness(EContact customer) {
        return contactDao.save(customer);
    }

    public EContact execute(EContact customer) throws EntityAlreadyExistsException {
        validate(customer);
        return doBusiness(customer);
    }
}
