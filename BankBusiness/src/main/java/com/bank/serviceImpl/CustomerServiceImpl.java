package com.bank.serviceImpl;

import com.bank.business.customer.*;
import com.bank.business.factory.BusinessFactory;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfContact;
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
    CustomerServiceImpl(BusinessFactory businessFactory) {
        this.registerCustomerBusiness = businessFactory.getRegisterCustomerBusiness();
        this.deleteCustomerBusiness = businessFactory.getDeleteCustomerBusiness();
        this.findCustomersBusiness = businessFactory.getFindCustomersBusiness();
        this.updateCustomerBusiness = businessFactory.getUpdateCustomerBusiness();
    }

    @Override
    public EContact saveCustomer(EContact customer) throws EntityAlreadyExistsException {

        return registerCustomerBusiness.execute(customer);
    }

    @Override
    public void deleteCustomerById(String identityNo) throws EntityNotExistsException {
        deleteCustomerBusiness.execute(identityNo);
    }

    @Override
    public void updateCustomer(EContact customer) throws EntityNotExistsException {
        updateCustomerBusiness.execute(customer);
    }

    @Override
    public List<EContact> findCustomer(EfContact efContact) {
        return findCustomersBusiness.execute(efContact);
    }
}
