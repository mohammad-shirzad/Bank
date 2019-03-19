package service;

import entity.Customer;
import org.springframework.transaction.annotation.Transactional;
import util.xmlCollectionUtil.Type1;

import java.util.Date;

public interface CustomerService {
    @Transactional
    Customer saveCustomer(String fullName, String nationalId,
                          Date dateOfBirth, String province, String city, String street,
                          int number, Type1 cards);

    @Transactional
    Customer editExistingCustomer(Customer customer, String IP);

    @Transactional
    Customer getCustomerByNationalId(String nationalId);

    @Transactional
    Customer findCustomerByNationalId(String nationalId);
}
