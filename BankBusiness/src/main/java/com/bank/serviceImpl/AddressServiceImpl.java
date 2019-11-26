package com.bank.serviceImpl;

import com.bank.dao.bean.AddressDao;
import com.bank.data.entity.EAddress;
import com.bank.service.AddressService;

//@Service(value = "AddressService")
public class AddressServiceImpl implements AddressService {

    //    @Autowired
    private AddressDao addressDao;

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public EAddress getAddressByCustomerId(int cid) {
        return null;
    }

    @Override
    public EAddress saveAddress(EAddress address) {
        addressDao.save(address);
        return address;
    }
}
