package com.bank.controller.soap;

import com.bank.controller.request.*;
import com.bank.controller.response.*;
import com.bank.domain.data.exception.EntityAlreadyExistsException;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.exception.HolderException;
import com.bank.domain.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BankEndPointSoap {

    @WebMethod(operationName = "createCustomer")
    CreateCustomerResponse createCustomer(@WebParam(name = "createCustomerRequest") CreateCustomerRequest customer) throws EntityAlreadyExistsException;

    @WebMethod(operationName = "deleteCustomer")
    DeleteCustomerByIdResponse deleteCustomer(@WebParam(name = "deleteCustomer") DeleteCustomerByIdentityRequest request) throws EntityNotExistsException;

    @WebMethod(operationName = "findCustomers")
    FindCustomerResponse findCustomers(@WebParam(name = "findCustomers") FindCustomerRequest request);

    @WebMethod(operationName = "updateCustomer")
    UpdateCustomerResponse updateCustomer(@WebParam(name = "updateCustomer") UpdateCustomerRequest request) throws EntityNotExistsException;

    @WebMethod(operationName = "issueCard")
    IssueCardResponse issueCard(@WebParam(name = "issueCard") IssueCardRequest request) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, PaymentApplicationTypeNotSupportCardWithoutHolderException;

    @WebMethod(operationName = "getCardFullDetails")
    GetCardFullDetailsResponse getCardFullDetails(@WebParam(name = "getCardFullDetails") GetCardFullDetailsRequest request);
}
