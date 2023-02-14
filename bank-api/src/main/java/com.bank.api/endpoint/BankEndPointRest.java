package com.bank.api.endpoint;

import com.bank.api.request.*;
import com.bank.api.response.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/bank")
public interface BankEndPointRest {
    @RequestMapping(method = RequestMethod.POST, value = "/createCustomer")
    CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/deleteCustomer")
    DeleteCustomerByIdResponse deleteCustomer(@RequestBody DeleteCustomerByIdentityRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/findCustomers")
    FindCustomerResponse findCustomers(@RequestBody FindCustomerRequest request);

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateCustomer")
    UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request);

    @RequestMapping(method = RequestMethod.POST, value = "/issueCard")
    IssueCardResponse issueCard(@RequestBody IssueCardRequest request);

    @RequestMapping(method = RequestMethod.GET, value = "/getCardFullDetails")
    GetCardFullDetailsResponse getCardFullDetails(@RequestBody GetCardFullDetailsRequest request);
}
