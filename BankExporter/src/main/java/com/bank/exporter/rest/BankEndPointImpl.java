package com.bank.exporter.rest;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.facade.facade.BankFacade;
import com.bank.facade.request.*;
import com.bank.facade.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class BankEndPointImpl {
    private BankFacade bankFacade;

    @Autowired
    public void setBankFacade(BankFacade bankFacade) {
        this.bankFacade = bankFacade;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createCustomer")
    public CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) throws EntityAlreadyExistsException, SQLException {
        return bankFacade.createNewCustomer(request);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteCustomer")
    public DeleteCustomerByIdResponse deleteCustomer(@RequestBody DeleteCustomerByIdentityRequest request) throws EntityNotExistsException, SQLException {
        return bankFacade.deleteCustomerById(request);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findCustomers")
    public FindCustomerResponse findCustomers(@RequestBody FindCustomerRequest request) throws SQLException {
        return bankFacade.findCustomer(request);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateCustomer")
    public UpdateCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request) throws EntityNotExistsException, SQLException {
        return bankFacade.updateCustomer(request);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/issueCard")
    public IssueCardResponse issueCard(@RequestBody IssueCardRequest request) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException, EntityAlreadyExistsException {
        return bankFacade.issueCard(request);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getCardFullDetails")
    public GetCardFullDetailsResponse getCardFullDetails(@RequestBody GetCardFullDetailsRequest request) {
        return bankFacade.getCardFullDetails(request);
    }
}
