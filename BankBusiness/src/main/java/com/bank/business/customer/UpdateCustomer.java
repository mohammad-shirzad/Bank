package com.bank.business.customer;

import com.bank.dao.bean.ContactDao;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfContact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UpdateCustomer {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private ContactDao contactDao;

    public UpdateCustomer(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void execute(EContact customer) throws EntityNotExistsException {
        init();
        validate(customer);
        doBusiness(customer);
    }

    private void init() {

    }

    private void validate(EContact customer) throws EntityNotExistsException {

    }

    private void doBusiness(EContact customer) {
        EfContact efContact = new EfContact();
        efContact.setIdentityNo(customer.getIdentityNo());
        List<EContact> dbCustomers = contactDao.findByFilter(efContact);
        if (!dbCustomers.isEmpty()) {
            EContact eContact = dbCustomers.get(0);
            customer.setDateOfBirth(eContact.getDateOfBirth());
            customer.setCustomerNo(eContact.getCustomerNo());
            customer.getAddress().setId(dbCustomers.get(0).getAddress().getId());
            if (customer.getCards() == null)
                customer.setCards(new ArrayList<>());
            else
                customer.setCards(eContact.getCards());
            contactDao.save(customer);
        } else {
            throw new EntityNotFoundException("Customer with identityNo " + customer.getIdentityNo() + " does not exist");
        }

    }
}
