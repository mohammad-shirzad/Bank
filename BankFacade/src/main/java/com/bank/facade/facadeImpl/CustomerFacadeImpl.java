package com.bank.facade.facadeImpl;

import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.service.CustomerService;
import com.bank.data.entity.Customer;
import com.bank.facade.facade.CustomerFacade;
import com.bank.facade.request.CreateCustomerRequest;
import com.bank.facade.request.DeleteCustomerByIdRequest;
import com.bank.facade.response.CreateCustomerResponse;
import com.bank.facade.response.DeleteCustomerByIdResponse;
import com.common.utils.singleton.DozerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "CustomerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws CustomerAlreadyExistsException {
        if (request == null)
            return null;
        Customer customer = DozerMapper.getDozerBeanMapper().map(request, Customer.class);
        customer = customerService.saveCustomer(customer);
        CreateCustomerResponse response = DozerMapper.getDozerBeanMapper().map(customer, CreateCustomerResponse.class);
        return response;

    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdRequest request) {
        if (request == null)
            return null;
        Customer customer = DozerMapper.getDozerBeanMapper().map(request, Customer.class);
        customerService.deleteCustomerById(customer.getId());
        return new DeleteCustomerByIdResponse();
    }
}
