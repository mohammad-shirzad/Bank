package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECustomer;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.RequiredArgumentException;
import com.bank.data.filter.EfCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class RegisterCustomerBusiness {


    private CustomerDao customerDao;

    @Autowired
    RegisterCustomerBusiness(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }

    public void validate(ECustomer customer) throws EntityAlreadyExistsException {
        if (customer.getIdentityNo() == null && customer.getIdentityNo() == null)
            throw new RequiredArgumentException("Identity number & CustomerNo can not be null");
        EfCustomer efCustomer = new EfCustomer();
        efCustomer.setIdentityNo(customer.getIdentityNo());
        efCustomer.setIdentityType(customer.getIdentityType());
        List<ECustomer> dbCustomer = customerDao.find(efCustomer);
        if (!dbCustomer.isEmpty())
            throw new EntityAlreadyExistsException("customer with identity number " + customer.getIdentityNo() +
                    " was registered before");
    }

    public ECustomer doBusiness(ECustomer customer) {
        customer.setLastModificationDate(Calendar.getInstance().getTime());
        return customerDao.save(customer);
    }

    public ECustomer execute(ECustomer customer) throws EntityAlreadyExistsException {
        validate(customer);
        return doBusiness(customer);
    }
}
