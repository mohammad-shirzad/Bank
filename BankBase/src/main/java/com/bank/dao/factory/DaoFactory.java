package com.bank.dao.factory;

import com.bank.dao.bean.AddressDao;
import com.bank.dao.bean.CardDao;
import com.bank.dao.bean.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoFactory {

    private static ContactDao contactDao;
    private static AddressDao addressDao;
    private static CardDao cardDao;

    @Autowired
    private void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Autowired
    private void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Autowired
    private void setCardDao(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public static ContactDao getContactDao() {
        return contactDao;
    }

    public static AddressDao getAddressDao() {
        return addressDao;
    }

    public static CardDao getCardDao() {
        return cardDao;
    }
}
