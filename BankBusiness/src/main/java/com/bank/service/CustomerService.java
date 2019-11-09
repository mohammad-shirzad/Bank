package com.bank.service;

import com.bank.data.entity.Customer;
import com.bank.data.exception.CustomerAlreadyExistsException;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface CustomerService {

    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException;

    public void deleteCustomerById(long id);
}
