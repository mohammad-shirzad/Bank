package serviceImpl;

import dao.AddressDao;
import entity.Address;
import service.AddressService;

public class AddressServiceImpl implements AddressService {
    AddressDao addressDao;

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Address getAddressByCustomerId(int cid) {
        return null;
    }

    @Override
    public Address saveAddress(Address address) {
        addressDao.create(address);
        return address;
    }
}
