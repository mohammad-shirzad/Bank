package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECustomer;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class DeleteCustomerBusiness {

    private CustomerDao customerDao;
    private ECustomer dbCustomer;

    @Autowired
    DeleteCustomerBusiness(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }

    public void init(String identityNo) throws SQLException {
        EfCustomer efCustomer = new EfCustomer();
        efCustomer.setIdentityNo(identityNo);
        List<ECustomer> dbCustomers = customerDao.find(efCustomer);
        dbCustomer = dbCustomers.isEmpty() ? null : dbCustomers.get(0);
    }

    public void validate(String identityNo) throws EntityNotExistsException {
        if (dbCustomer == null)
            throw new EntityNotExistsException("Customer with identity no " + identityNo + " does not exists");
    }

    public void doBusiness() {
        customerDao.delete(dbCustomer);
    }

    public void execute(String identityNo) throws EntityNotExistsException, SQLException {
        init(identityNo);
        validate(identityNo);
        doBusiness();
    }
}
