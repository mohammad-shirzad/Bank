package com.bank.business.customer;

import com.bank.dao.bean.ContactDao;
import com.bank.data.entity.*;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.filter.EfContact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bank.data.exception.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class UpdateCustomerBusiness {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private ContactDao contactDao;

    @Autowired
    public void setContactDao(DaoFactory daoFactory) {
        this.contactDao = daoFactory.getContactDao();
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
        customer.setLastModificationDate(Calendar.getInstance().getTime());
        EfContact efContact = new EfContact();
        efContact.setIdentityNo(customer.getIdentityNo());
        List<EContact> dbCustomers = contactDao.find(efContact);
        if (!dbCustomers.isEmpty()) {
            EContact eContact = dbCustomers.get(0);
            customer.setDateOfBirth(eContact.getDateOfBirth());
            customer.setCustomerNo(eContact.getCustomerNo());
            customer.getAddress().setId(dbCustomers.get(0).getAddress().getId());
            if (customer.getCards() == null)
                customer.setCards(new ArrayList<>());
            else
                customer.setCards(eContact.getCards());
            contactDao.update(customer);
        } else {
            throw new EntityNotFoundException("Customer with identityNo " + customer.getIdentityNo() + " does not exist");
        }

    }
}
