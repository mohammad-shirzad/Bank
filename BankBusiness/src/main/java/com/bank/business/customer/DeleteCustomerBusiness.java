package com.bank.business.customer;

import com.bank.dao.bean.CustomerDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECustomer;
import com.bank.data.exception.CustomerNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerBusiness {

    private CustomerDao customerDao;
    private ECustomer dbCustomer;

    @Autowired
    DeleteCustomerBusiness(DaoFactory daoFactory) {
        this.customerDao = daoFactory.getCustomerDao();
    }

    public void init(String identityNo) {
        dbCustomer = customerDao.findCustomerByIdentityNo(identityNo);
    }

    public void validate(String identityNo) throws CustomerNotExistsException {
        if (dbCustomer == null)
            throw new CustomerNotExistsException("Customer with identity no " + identityNo + " does not exists");
    }

    public void doBusiness() {


        customerDao.delete(dbCustomer);
    }

    public void execute(String identityNo) throws CustomerNotExistsException {
        init(identityNo);
        validate(identityNo);
        doBusiness();
    }
}
