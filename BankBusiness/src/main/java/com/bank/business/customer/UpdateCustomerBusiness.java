package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.data.entity.*;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.filter.EfCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bank.data.exception.*;

@Component
public class UpdateCustomerBusiness {
    private CustomerDao customerDao;
    private ECustomer dbCustomer;
    private EfCustomer efCustomer;

    @Autowired
    public void setCustomerDao(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }

    public void execute(ECustomer customer) throws CustomerNotExistsException {
        init();
        validate(customer);
        doBusiness(customer);
    }

    private void init() {

    }

    private void validate(ECustomer customer) throws CustomerNotExistsException {

    }

    private void doBusiness(ECustomer customer) {
        customerDao.update(customer);
    }
}
