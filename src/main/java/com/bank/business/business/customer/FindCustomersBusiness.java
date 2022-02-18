package com.bank.business.business.customer;

import com.bank.dao.repository.ContactDao;
import com.bank.data.entity.EContact;
import com.bank.data.filter.EfContact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindCustomersBusiness {
    private ContactDao contactDao;
    private EContact customer;

    public FindCustomersBusiness(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public List<EContact> execute(EfContact efContact) {
        return doBusiness(efContact);
    }

    private void init() {

    }

    private void validate(EfContact efContact) {

    }

    private List<EContact> doBusiness(EfContact efContact) {
        return contactDao.findByFilter(efContact);
    }
}
