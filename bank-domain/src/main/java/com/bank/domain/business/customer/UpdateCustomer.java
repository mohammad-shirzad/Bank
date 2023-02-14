package com.bank.domain.business.customer;

import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.filter.EfContact;
import com.bank.domain.providerapi.ContactDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
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
        List<EContact> dbContacts = contactDao.findByFilter(efContact);
        if (!dbContacts.isEmpty()) {
            EContact dbContact = dbContacts.get(0);
            dbContact.setFirstName(customer.getFirstName());
            dbContact.setLastName(customer.getLastName());
            dbContact.setCustomerNo(customer.getCustomerNo());
            contactDao.save(dbContact);
        } else {
            throw new EntityNotFoundException("Customer with identityNo " + customer.getIdentityNo() + " does not exist");
        }

    }
}
