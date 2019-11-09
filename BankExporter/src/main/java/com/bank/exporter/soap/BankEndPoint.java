package com.bank.exporter.soap;

import com.bank.data.exception.CustomerAlreadyExistsException;
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
    CreateCustomerResponse createCustomer(@WebParam(name = "CreateCustomerRequest") CreateCustomerRequest customer) throws CustomerAlreadyExistsException;

    @WebMethod(operationName = "deleteCustomerById")
    DeleteCustomerByIdResponse deleteCustomerById(@WebParam(name = "DeleteCustomerById") DeleteCustomerByIdRequest request);
}
