package com.bank.business.customer;

import com.bank.dao.bean.ContactDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "prototype")
public class DeleteCustomerBusiness {

    private ContactDao contactDao;
    private EContact dbCustomer;

    @Autowired
    DeleteCustomerBusiness(DaoFactory daoFactory) {
        this.contactDao = daoFactory.getContactDao();
    }

    public void init(String identityNo) {
        EfContact efContact = new EfContact();
        efContact.setIdentityNo(identityNo);
        List<EContact> dbCustomers = contactDao.find(efContact);
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
