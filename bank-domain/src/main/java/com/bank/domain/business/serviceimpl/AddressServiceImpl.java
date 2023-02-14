package com.bank.domain.business.serviceimpl;

import com.bank.domain.business.service.AddressService;
import com.bank.domain.data.entity.EAddress;
import com.bank.domain.providerapi.AddressDao;

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
