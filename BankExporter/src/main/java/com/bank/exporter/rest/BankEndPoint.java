package com.bank.exporter.rest;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.facade.request.*;
import com.bank.facade.response.*;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping(value = "/rest")
public interface BankEndPoint {
    @RequestMapping(method = RequestMethod.POST, value = "/createCustomer")
    CreateCustomerResponse createCustomer(@RequestParam(name = "request") CreateCustomerRequest request) throws EntityAlreadyExistsException, SQLException;

    @RequestMapping(method = RequestMethod.POST, value = "/deleteCustomer")
    DeleteCustomerByIdResponse deleteCustomer(@RequestParam(name = "request") DeleteCustomerByIdentityRequest request) throws EntityNotExistsException, SQLException;

    @RequestMapping(method = RequestMethod.POST, value = "/findCustomers")
    FindCustomerResponse findCustomers(@RequestParam(name = "request") FindCustomerRequest request) throws SQLException;

    @RequestMapping(method = RequestMethod.POST, value = "/updateCustomer")
    UpdateCustomerResponse updateCustomer(@RequestParam(name = "request") UpdateCustomerRequest request) throws EntityNotExistsException, SQLException;

    @RequestMapping(method = RequestMethod.POST, value = "/issueCard")
    IssueCardResponse issueCard(@RequestParam(name = "request") IssueCardRequest request) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, SQLException, PaymentApplicationTypeNotSupportCardWithoutHolderException;
}
