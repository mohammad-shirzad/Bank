package com.bank.api.endpoint;

import com.bank.api.request.*;
import com.bank.api.response.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BankEndPointSoap {

    @WebMethod(operationName = "createCustomer")
    CreateCustomerResponse createCustomer(@WebParam(name = "createCustomerRequest") CreateCustomerRequest customer);

    @WebMethod(operationName = "deleteCustomer")
    DeleteCustomerByIdResponse deleteCustomer(@WebParam(name = "deleteCustomer") DeleteCustomerByIdentityRequest request);

    @WebMethod(operationName = "findCustomers")
    FindCustomerResponse findCustomers(@WebParam(name = "findCustomers") FindCustomerRequest request);

    @WebMethod(operationName = "updateCustomer")
    UpdateCustomerResponse updateCustomer(@WebParam(name = "updateCustomer") UpdateCustomerRequest request);

    @WebMethod(operationName = "issueCard")
    IssueCardResponse issueCard(@WebParam(name = "issueCard") IssueCardRequest request);

    @WebMethod(operationName = "getCardFullDetails")
    GetCardFullDetailsResponse getCardFullDetails(@WebParam(name = "getCardFullDetails") GetCardFullDetailsRequest request);
}
