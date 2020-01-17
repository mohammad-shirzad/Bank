package com.bank.serviceImpl;

import com.bank.business.customer.*;
import com.bank.data.entity.ECustomer;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfCustomer;
import com.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService {


    private RegisterCustomerBusiness registerCustomerBusiness;
    private DeleteCustomerBusiness deleteCustomerBusiness;
    private FindCustomersBusiness findCustomersBusiness;
    private UpdateCustomerBusiness updateCustomerBusiness;

    @Autowired
    CustomerServiceImpl(CustomerBusinessFactory customerBusinessFactory) {
        this.registerCustomerBusiness = customerBusinessFactory.getRegisterCustomerBusiness();
        this.deleteCustomerBusiness = customerBusinessFactory.getDeleteCustomerBusiness();
        this.findCustomersBusiness = customerBusinessFactory.getFindCustomersBusiness();
        this.updateCustomerBusiness = customerBusinessFactory.getUpdateCustomerBusiness();
    }

    @Override
    public ECustomer saveCustomer(ECustomer customer) throws EntityAlreadyExistsException, SQLException {

        return registerCustomerBusiness.execute(customer);
    }

    @Override
    public void deleteCustomerById(String identityNo) throws EntityNotExistsException, SQLException {
        deleteCustomerBusiness.execute(identityNo);
    }

    @Override
    public void updateCustomer(ECustomer customer) throws EntityNotExistsException, SQLException {
        updateCustomerBusiness.execute(customer);
    }

    @Override
    public List<ECustomer> findCustomer(EfCustomer efCustomer) throws SQLException {
        return findCustomersBusiness.execute(efCustomer);
    }
}
