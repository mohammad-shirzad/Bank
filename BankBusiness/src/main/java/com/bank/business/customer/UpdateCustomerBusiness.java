package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.data.entity.*;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.filter.EfCustomer;
import com.common.utils.date.CurrentDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bank.data.exception.*;

import javax.persistence.EntityNotFoundException;
import java.util.Calendar;

@Component
public class UpdateCustomerBusiness {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
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
        customer.setLastModificationDate(Calendar.getInstance().getTime());
        ECustomer dbCustomer = customerDao.getReference(customer.getIdentityNo());
        try {
            customer.getAddress().setId(dbCustomer.getAddress().getId());
        } catch (EntityNotFoundException exp) {
            LOGGER.info("Customer with ID NO " + customer.getIdentityNo() + " Not found");
            customerDao.save(customer);
            return;
        }
        customerDao.update(customer);
    }
}
