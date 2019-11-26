package com.bank.serviceImpl;

import com.bank.business.customer.*;
import com.bank.data.entity.ECustomer;
import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.data.exception.CustomerNotExistsException;
import com.bank.data.filter.EfCustomer;
import com.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ECustomer saveCustomer(ECustomer customer) throws CustomerAlreadyExistsException {

        return registerCustomerBusiness.execute(customer);
    }

    @Override
    public void deleteCustomerById(String identityNo) throws CustomerNotExistsException {
        deleteCustomerBusiness.execute(identityNo);
    }

    @Override
    public void updateCustomer(ECustomer customer) throws CustomerNotExistsException {
        updateCustomerBusiness.execute(customer);
    }

    @Override
    public List<ECustomer> findCustomer(EfCustomer efCustomer) {
        return findCustomersBusiness.execute(efCustomer);
    }
}
