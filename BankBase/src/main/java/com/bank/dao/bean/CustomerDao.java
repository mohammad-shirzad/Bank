package com.bank.dao.bean;

import com.bank.data.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface CustomerDao extends CrudRepository<Customer, Long> {

    public Customer findCustomerByCustomerNumber(String customerNo);

    public Customer findCustomerByIdentityNumber(String identityNo);

}
