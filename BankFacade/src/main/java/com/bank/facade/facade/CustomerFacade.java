package com.bank.facade.facade;

import com.bank.data.exception.CustomerAlreadyExistsException;
import com.bank.facade.request.*;
import com.bank.facade.response.*;

public interface CustomerFacade {
    CreateCustomerResponse createNewCustomer(CreateCustomerRequest request) throws CustomerAlreadyExistsException;

    DeleteCustomerByIdResponse deleteCustomerById(DeleteCustomerByIdRequest request);
}
