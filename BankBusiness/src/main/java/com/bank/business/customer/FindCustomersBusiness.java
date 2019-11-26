package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECustomer;
import com.bank.data.exception.RequiredArgumentException;
import com.bank.data.filter.EfCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindCustomersBusiness {
    private CustomerDao customerDao;
    private ECustomer customer;

    @Autowired
    public void setCustomerDao(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }

    public List<ECustomer> execute(EfCustomer efCustomer) {
        return doBusiness(efCustomer);
    }

    private void init() {

    }

    private void validate(EfCustomer efCustomer) {

    }

    private List<ECustomer> doBusiness(EfCustomer efCustomer) {
        return customerDao.find(efCustomer);
    }
}
