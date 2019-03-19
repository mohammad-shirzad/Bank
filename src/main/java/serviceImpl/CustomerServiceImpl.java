package serviceImpl;

import dao.AddressDao;
import dao.CustomerDao;
import entity.Address;
import entity.Card;
import entity.Customer;
import service.CustomerService;
import util.xmlCollectionUtil.Type1;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private AddressDao addressDao;


    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Override
    public Customer saveCustomer(String fullName, String nationalId,
                                 Date dateOfBirth, String province,
                                 String city, String street,
                                 int number, Type1 cards) {
        Customer customer = new Customer();

        customer.setFullName(fullName);
        customer.setNationalId(nationalId);
        customer.setDateOfBirth(dateOfBirth);
        Address address = new Address();
        address.setProvince(province);
        address.setCity(city);
        address.setStreet(street);
        address.setNumber(number);
        customer.setAddress(address);

        Set<Card> cardSet = new HashSet<>();
        for (String cardNumber : cards.getCardNumbers()
                ) {
            cardSet.add(new Card(cardNumber));
        }
        for (Card card : cardSet
                ) {
            card.setCustomer(customer);
        }
        customer.setCards(cardSet);
        customerDao.create(customer);
        return customer;
    }

    @Override
    public Customer editExistingCustomer(Customer customer, String ip) {
        try {
            Customer dbCustomer = customerDao.getCustomerByNationalId(customer.getNationalId());
            dbCustomer.setFullName(customer.getFullName());
            dbCustomer.setAddress(customer.getAddress());
            dbCustomer.setCards(customer.getCards());
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer getCustomerByNationalId(String nationalId) {
        Customer customer = customerDao.findCustomerByNationalId(nationalId);
        return customer;
    }

    @Override
    public Customer findCustomerByNationalId(String nationalId) {
        return customerDao.findCustomerByNationalId(nationalId);
    }


}
