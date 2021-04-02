package com.bank.serviceImpl;

import com.bank.business.customer.DeleteCustomerBusiness;
import com.bank.business.customer.FindCustomersBusiness;
import com.bank.business.customer.RegisterCustomerBusiness;
import com.bank.business.customer.UpdateCustomerBusiness;
import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfContact;
import com.bank.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService {


    private RegisterCustomerBusiness registerCustomerBusiness;
    private DeleteCustomerBusiness deleteCustomerBusiness;
    private FindCustomersBusiness findCustomersBusiness;
    private UpdateCustomerBusiness updateCustomerBusiness;

    @Override
    public EContact saveCustomer(EContact customer) throws EntityAlreadyExistsException {

        return new RegisterCustomerBusiness().execute(customer);
    }

    @Override
    public void deleteCustomerById(String identityNo) throws EntityNotExistsException {
        new DeleteCustomerBusiness().execute(identityNo);
    }

    @Override
    public void updateCustomer(EContact customer) throws EntityNotExistsException {
        new UpdateCustomerBusiness().execute(customer);
    }

    @Override
    public List<EContact> findCustomer(EfContact efContact) {
        return new FindCustomersBusiness().execute(efContact);
    }
}
