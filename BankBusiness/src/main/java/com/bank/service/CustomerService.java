package com.bank.service;

import com.bank.data.entity.ECustomer;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.CustomerNotExistsException;
import com.bank.data.filter.EfCustomer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CustomerService {

    public ECustomer saveCustomer(ECustomer customer) throws EntityAlreadyExistsException;

    public void deleteCustomerById(String identityNo) throws CustomerNotExistsException;

    public void updateCustomer(ECustomer customer) throws CustomerNotExistsException;

    public List<ECustomer> findCustomer(EfCustomer efCustomer);
}
