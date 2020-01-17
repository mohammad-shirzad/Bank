package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.data.entity.*;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.filter.EfCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bank.data.exception.*;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component
public class UpdateCustomerBusiness {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }

    public void execute(ECustomer customer) throws EntityNotExistsException, SQLException {
        init();
        validate(customer);
        doBusiness(customer);
    }

    private void init() {

    }

    private void validate(ECustomer customer) throws EntityNotExistsException {

    }

    private void doBusiness(ECustomer customer) throws SQLException {
        customer.setLastModificationDate(Calendar.getInstance().getTime());
        EfCustomer efCustomer = new EfCustomer();
        efCustomer.setIdentityNo(customer.getIdentityNo());
        List<ECustomer> dbCustomers = customerDao.find(efCustomer);
        if (!dbCustomers.isEmpty()) {
            ECustomer eCustomer = dbCustomers.get(0);
            customer.setDateOfBirth(eCustomer.getDateOfBirth());
            customer.setCustomerNo(eCustomer.getCustomerNo());
            customer.getAddress().setId(dbCustomers.get(0).getAddress().getId());
            if (customer.getCards() == null)
                customer.setCards(new ArrayList<>());
            else
                customer.setCards(eCustomer.getCards());
            customerDao.update(customer);
        } else {
            throw new EntityNotFoundException("Customer with identityNo " + customer.getIdentityNo() + " does not exist");
        }

    }
}
