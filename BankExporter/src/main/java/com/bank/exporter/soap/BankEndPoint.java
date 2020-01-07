package com.bank.exporter.soap;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.CustomerNotExistsException;
import com.bank.facade.request.*;
import com.bank.facade.response.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BankEndPoint {

    @WebMethod(operationName = "createCustomer")
    CreateCustomerResponse createCustomer(@WebParam(name = "createCustomerRequest") CreateCustomerRequest customer) throws EntityAlreadyExistsException;

    @WebMethod(operationName = "deleteCustomer")
    DeleteCustomerByIdResponse deleteCustomer(@WebParam(name = "deleteCustomer") DeleteCustomerByIdentityRequest request) throws CustomerNotExistsException;

    @WebMethod(operationName = "findCustomers")
    FindCustomerResponse findCustomers(@WebParam(name = "findCustomers") FindCustomerRequest request);

    @WebMethod(operationName = "updateCustomer")
    UpdateCustomerResponse updateCustomer(@WebParam(name = "updateCustomer") UpdateCustomerRequest request) throws CustomerNotExistsException;
}
