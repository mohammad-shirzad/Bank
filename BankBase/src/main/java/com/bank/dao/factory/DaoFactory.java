package com.bank.dao.factory;

import com.bank.dao.bean.AddressDao;
import com.bank.dao.bean.CardDao;
import com.bank.dao.bean.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoFactory {

    private ContactDao contactDao;
    private AddressDao addressDao;
    private CardDao cardDao;

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

    public ContactDao getContactDao() {
        return contactDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public CardDao getCardDao() {
        return cardDao;
    }
}
