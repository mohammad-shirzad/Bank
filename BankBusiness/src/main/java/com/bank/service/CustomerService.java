package com.bank.service;

import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfContact;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CustomerService {

    long saveCustomer(EContact customer) throws EntityAlreadyExistsException;

    void deleteCustomerById(String identityNo) throws EntityNotExistsException;

    void updateCustomer(EContact customer) throws EntityNotExistsException;

    List<EContact> findCustomer(EfContact efContact);
}
