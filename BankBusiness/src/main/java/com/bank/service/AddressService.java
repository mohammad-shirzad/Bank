package com.bank.service;

import com.bank.data.entity.Address;

@org.springframework.transaction.annotation.Transactional
public interface AddressService {

    Address saveAddress(Address address);

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    Address getAddressByCustomerId(int cid);
}
