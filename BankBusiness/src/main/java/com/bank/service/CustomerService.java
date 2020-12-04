package com.bank.service;

import com.bank.data.entity.EContact;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfContact;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CustomerService {

    public EContact saveCustomer(EContact customer) throws EntityAlreadyExistsException;

    public void deleteCustomerById(String identityNo) throws EntityNotExistsException;

    public void updateCustomer(EContact customer) throws EntityNotExistsException;

    public List<EContact> findCustomer(EfContact efContact);
}
