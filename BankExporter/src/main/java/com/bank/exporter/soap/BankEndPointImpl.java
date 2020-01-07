package com.bank.exporter.soap;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.CustomerNotExistsException;
import com.bank.facade.facade.CustomerFacade;
import com.bank.facade.request.CreateCustomerRequest;
import com.bank.facade.request.DeleteCustomerByIdentityRequest;
import com.bank.facade.request.FindCustomerRequest;
import com.bank.facade.request.UpdateCustomerRequest;
import com.bank.facade.response.CreateCustomerResponse;
import com.bank.facade.response.DeleteCustomerByIdResponse;
import com.bank.facade.response.FindCustomerResponse;
import com.bank.facade.response.UpdateCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component(value = "BankSOAPEndpoint")
@WebService(endpointInterface = "com.bank.exporter.soap.BankEndPoint")
public class BankEndPointImpl implements BankEndPoint {


    private CustomerFacade customerFacade;

    @Autowired
    @WebMethod(exclude = true)
    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException {
        return customerFacade.createNewCustomer(request);
    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomer(DeleteCustomerByIdentityRequest request) throws CustomerNotExistsException {
        return customerFacade.deleteCustomerById(request);
    }

    @Override
    public FindCustomerResponse findCustomers(FindCustomerRequest request) {
        return customerFacade.findCustomer(request);
    }

    @Override
    public UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws CustomerNotExistsException {
        return customerFacade.updateCustomer(request);
    }
}
