package service;

import entity.Address;

public interface AddressService {
    Address saveAddress(Address address);

    Address getAddressByCustomerId(int cid);
}
