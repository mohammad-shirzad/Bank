package com.bank.dao.bean;

import com.bank.data.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface AddressDao extends CrudRepository<Address, Long> {
}
