package com.bank.dao.impl;

import com.bank.dao.bean.ContactDao;
import com.bank.data.entity.EContact;
import com.bank.data.filter.EfContact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository(value = "ContactDao")
public class ContactDaoImpl extends BaseGenericDaoImpl<EContact, String> implements ContactDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactDaoImpl.class);

    @Override
    public List<EContact> find(Object filter) {
        EfContact efContact = (EfContact) filter;
        Query query = em.createNamedQuery("customer.findCustomer");
        query.setParameter("customerNo", efContact.getCustomerNo());
        query.setParameter("holderId", efContact.getHolderId());

        return query.getResultList();
    }
}
