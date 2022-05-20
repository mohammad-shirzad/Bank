package com.bank.business.business.customer;

import com.bank.dao.ContactDao;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.RequiredArgumentException;
import com.bank.data.filter.EfContact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterCustomer {


    private ContactDao contactDao;

    public RegisterCustomer(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void validate(EContact customer) throws EntityAlreadyExistsException {
        if (customer.getIdentityNo() == null && customer.getIdentityNo() == null)
            throw new RequiredArgumentException("Identity number & CustomerNo can not be null");
        EfContact efContact = new EfContact();
        efContact.setIdentityNo(customer.getIdentityNo());
        efContact.setCustomerNo(customer.getCustomerNo());
        List<EContact> dbCustomer = contactDao.findByFilter(efContact);
        if (!dbCustomer.isEmpty())
            throw new EntityAlreadyExistsException("customer with identity number " + customer.getIdentityNo() +
                    " was registered before");
    }

    public long doBusiness(EContact customer) {
        customer = contactDao.save(customer);
        return customer.getId();
    }

    public long execute(EContact customer) throws EntityAlreadyExistsException {
        validate(customer);
        return doBusiness(customer);
    }
}
