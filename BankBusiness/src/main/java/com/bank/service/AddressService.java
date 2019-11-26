package com.bank.service;

import com.bank.data.entity.EAddress;

@org.springframework.transaction.annotation.Transactional
public interface AddressService {

    EAddress saveAddress(EAddress address);

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    EAddress getAddressByCustomerId(int cid);
}
