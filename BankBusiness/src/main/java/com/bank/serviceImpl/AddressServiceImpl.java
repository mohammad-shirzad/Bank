package com.bank.serviceImpl;

import com.bank.dao.bean.AddressDao;
import com.bank.service.AddressService;
import com.bank.data.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service(value = "AddressService")
public class AddressServiceImpl implements AddressService {

    //    @Autowired
    private AddressDao addressDao;

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Address getAddressByCustomerId(int cid) {
        return null;
    }

    @Override
    public Address saveAddress(Address address) {
        addressDao.save(address);
        return address;
    }
}
