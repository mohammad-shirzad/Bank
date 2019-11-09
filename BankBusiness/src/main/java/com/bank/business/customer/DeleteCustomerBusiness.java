package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerBusiness {

    private CustomerDao customerDao;

    @Autowired
    DeleteCustomerBusiness(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }


    public void validate(Customer customer) {

    }

    public void doBusiness(Customer customer) {
        customerDao.delete(customer);
    }

    public void execute(Customer customer) {
        validate(customer);
        doBusiness(customer);
    }
}
