package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.Customer;
import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.data.exception.RequiredArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegisterCustomerBusiness {


    private CustomerDao customerDao;

    @Autowired
    RegisterCustomerBusiness(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }

    public void validate(Customer customer) throws CustomerAlreadyExistsException {
        if (customer.getIdentityNumber() == null)
            throw new RequiredArgumentException("Identity number can not be null");

        Customer validCustomer = customerDao.findCustomerByIdentityNumber(customer.getIdentityNumber());
        if (validCustomer != null)
            throw new CustomerAlreadyExistsException("customer with identity number " + customer.getIdentityNumber() +
                    " was registered before");
    }

    public Customer doBusiness(Customer customer) {
        return customerDao.save(customer);
    }

    public Customer execute(Customer customer) throws CustomerAlreadyExistsException {
        validate(customer);
        return doBusiness(customer);
    }
}
