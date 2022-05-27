package com.bank.controller.rest;

import com.bank.controller.request.*;
import com.bank.controller.response.*;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@RequestMapping(value = "/bank")
public interface BankEndPoint {
    @RequestMapping(method = RequestMethod.POST, value = "/createCustomer")
    CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) throws EntityAlreadyExistsException, SQLException;

    @RequestMapping(method = RequestMethod.POST, value = "/deleteCustomer")
    DeleteCustomerByIdResponse deleteCustomer(@RequestBody DeleteCustomerByIdentityRequest request) throws EntityNotExistsException, SQLException;

    @RequestMapping(method = RequestMethod.POST, value = "/findCustomers")
    FindCustomerResponse findCustomers(@RequestBody FindCustomerRequest request) throws SQLException;

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateCustomer")
    UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request) throws EntityNotExistsException, SQLException;

    @RequestMapping(method = RequestMethod.POST, value = "/issueCard")
    IssueCardResponse issueCard(@RequestBody IssueCardRequest request) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, SQLException, PaymentApplicationTypeNotSupportCardWithoutHolderException;

    @RequestMapping(method = RequestMethod.GET, value = "/getCardFullDetails")
    public GetCardFullDetailsResponse getCardFullDetails(@RequestBody GetCardFullDetailsRequest request);
}
