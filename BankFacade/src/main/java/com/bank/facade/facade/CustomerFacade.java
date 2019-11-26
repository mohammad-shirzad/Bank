package com.bank.facade.facade;

import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.data.exception.CustomerNotExistsException;
import com.bank.facade.request.*;
import com.bank.facade.response.*;

public interface CustomerFacade {
    CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws CustomerAlreadyExistsException;

    DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdentityRequest request) throws CustomerNotExistsException;

    UpdateCustomerResponse updateCustomer(UpdateCustomerRequest request) throws CustomerNotExistsException;

    FindCustomerResponse findCustomer(FindCustomerRequest request);
}
