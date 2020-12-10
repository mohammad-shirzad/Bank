package com.bank.exporter.soap;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.facade.request.*;
import com.bank.facade.response.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BankEndPoint {

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
