package com.bank.domain.business.customer;

import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.filter.EfContact;
import com.bank.domain.providerapi.ContactDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteCustomer {

    private ContactDao contactDao;
    private EContact dbCustomer;

    public DeleteCustomer(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void init(String identityNo) {
        EfContact efContact = new EfContact();
        efContact.setIdentityNo(identityNo);
        List<EContact> dbCustomers = contactDao.findByFilter(efContact);
        dbCustomer = dbCustomers.isEmpty() ? null : dbCustomers.get(0);
    }

    public void validate(String identityNo) throws EntityNotExistsException {
        if (dbCustomer == null)
            throw new EntityNotExistsException("Customer with identity no " + identityNo + " does not exists");
    }

    public void doBusiness() {
        contactDao.delete(dbCustomer);
    }

    public void execute(String identityNo) throws EntityNotExistsException {
        init(identityNo);
        validate(identityNo);
        doBusiness();
    }
}
