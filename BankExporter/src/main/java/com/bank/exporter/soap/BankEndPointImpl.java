package com.bank.exporter.soap;

import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.facade.facade.CustomerFacade;
import com.bank.facade.request.CreateCustomerRequest;
import com.bank.facade.request.DeleteCustomerByIdRequest;
import com.bank.facade.response.CreateCustomerResponse;
import com.bank.facade.response.DeleteCustomerByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

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
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) throws CustomerAlreadyExistsException {
        return customerFacade.createNewCustomer(request);
    }

    @Override
    public DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdRequest request) {
        return customerFacade.deleteCustomerById(request);
    }
}
