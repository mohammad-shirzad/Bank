package com.bank.dao.factory;

import com.bank.dao.bean.AddressDao;
import com.bank.dao.bean.CardDao;
import com.bank.dao.bean.ContactDao;
import com.bank.dao.impl.AddressDaoImpl;
import com.bank.dao.impl.CardDaoImpl;
import com.bank.dao.impl.ContactDaoImpl;
import com.bank.dao.util.BeanUtil;

public final class DaoFactory {

    private static DaoFactory DAO_FACTORY;

    public ContactDao getContactDao() {
        return BeanUtil.getBean(ContactDaoImpl.class);
    }

    public AddressDao getAddressDao() {
        return BeanUtil.getBean(AddressDaoImpl.class);
    }

    public CardDao getCardDao() {
        return BeanUtil.getBean(CardDaoImpl.class);
    }

    public static DaoFactory getInstance() {
        if (DAO_FACTORY == null) {
            synchronized (DaoFactory.class) {
                if (DAO_FACTORY == null)
                    DAO_FACTORY = new DaoFactory();
            }
        }
        return DAO_FACTORY;
    }

    private DaoFactory() {
    }
}
