package com.bank.serviceImpl;

import com.bank.business.customer.CustomerBusinessFactory;
import com.bank.business.customer.DeleteCustomerBusiness;
import com.bank.business.customer.RegisterCustomerBusiness;
import com.bank.data.entity.Customer;
import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CustomerService")
public class CustomerServiceImpl implements CustomerService {


    private RegisterCustomerBusiness registerCustomerBusiness;
    private DeleteCustomerBusiness deleteCustomerBusiness;

    @Autowired
    CustomerServiceImpl(CustomerBusinessFactory customerBusinessFactory) {
        this.registerCustomerBusiness = customerBusinessFactory.getRegisterCustomerBusiness();
        this.deleteCustomerBusiness = customerBusinessFactory.getDeleteCustomerBusiness();
    }

    @Override
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException {

        return registerCustomerBusiness.execute(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        deleteCustomerBusiness.execute(new Customer());
    }
}
