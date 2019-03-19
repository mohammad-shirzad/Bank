package dao;

import entity.Customer;

public interface CustomerDao extends GenericDao<Customer> {

    Customer findCustomerByNationalId(String nationalId);

    Customer getCustomerByNationalId(String nationalId);
}
