package com.bank.service;

import com.bank.data.entity.ECustomer;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.filter.EfCustomer;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Transactional
public interface CustomerService {

    public ECustomer saveCustomer(ECustomer customer) throws EntityAlreadyExistsException, SQLException;

    public void deleteCustomerById(String identityNo) throws EntityNotExistsException, SQLException;

    public void updateCustomer(ECustomer customer) throws EntityNotExistsException, SQLException;

    public List<ECustomer> findCustomer(EfCustomer efCustomer) throws SQLException;
}
