package com.bank.business.customer;

import com.bank.dao.bean.ContactDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.EContact;
import com.bank.data.filter.EfContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindCustomersBusiness {
    private ContactDao contactDao;
    private EContact customer;

    @Autowired
    public void setContactDao(DaoFactory daoFactory) {
        this.contactDao = daoFactory.getContactDao();
    }

    public List<EContact> execute(EfContact efContact) {
        return doBusiness(efContact);
    }

    private void init() {

    }

    private void validate(EfContact efContact) {

    }

    private List<EContact> doBusiness(EfContact efContact) {
        return contactDao.find(efContact);
    }
}
