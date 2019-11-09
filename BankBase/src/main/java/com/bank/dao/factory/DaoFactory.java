package com.bank.dao.factory;

import com.bank.dao.bean.AddressDao;
import com.bank.dao.bean.CardDao;
import com.bank.dao.bean.CustomerDao;
import com.bank.data.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DaoFactory {

    private CustomerDao customerDao;
    private AddressDao addressDao;
    private CardDao cardDao;

    @Autowired
    private void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    private void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Autowired
    private void setCardDao(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public CardDao getCardDao() {
        return cardDao;
    }
}
