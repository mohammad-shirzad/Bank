package com.bank.domain.business.service;

import com.bank.domain.data.entity.EContact;
import com.bank.domain.data.exception.EntityAlreadyExistsException;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.filter.EfContact;

import javax.transaction.Transactional;
import java.util.List;


public interface CustomerService {

    @Transactional
    long saveCustomer(EContact customer) throws EntityAlreadyExistsException;

    @Transactional
    void deleteCustomerById(String identityNo) throws EntityNotExistsException;

    @Transactional
    void updateCustomer(EContact customer) throws EntityNotExistsException;

    List<EContact> findCustomer(EfContact efContact);
}
