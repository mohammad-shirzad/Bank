package com.bank.facade.facade;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.facade.request.*;
import com.bank.facade.response.*;

public interface BankFacade {
    CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException;

    DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdentityRequest request) throws EntityNotExistsException;

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsException;

    FindCustomerResponse findCustomer(FindCustomerRequest request);

    IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException;

    GetCardFullDetailsResponse getCardFullDetails(GetCardFullDetailsRequest request);
}
