package com.bank.facade.facade;

import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.facade.request.*;
import com.bank.facade.response.*;

import java.sql.SQLException;

public interface BankFacade {
    CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws EntityAlreadyExistsException, SQLException;

    DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdentityRequest request) throws EntityNotExistsException, SQLException;

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws EntityNotExistsException, SQLException;

    FindCustomerResponse findCustomer(FindCustomerRequest request) throws SQLException;

    IssueCardResponse issueCard(IssueCardRequest request) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, SQLException;
}
