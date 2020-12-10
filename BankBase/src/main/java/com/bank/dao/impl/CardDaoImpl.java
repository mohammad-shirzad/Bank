package com.bank.dao.impl;

import com.bank.dao.bean.CardDao;
import com.bank.data.entity.ECard;
import com.bank.data.filter.EfCard;
import com.bank.data.view.EvCard;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository(value = "CardDao")
public class CardDaoImpl extends BaseGenericDaoImpl<ECard> implements CardDao {
    @Override
    public List<ECard> find(Object filter) {
        Query query = em.createQuery("select c from ECard c where c.paymentApplicationNumber = :paymentApplicationNumber");
        query.setParameter("paymentApplicationNumber", ((ECard) filter).getPaymentApplicationNumber());
        return query.getResultList();
    }

    @Override
    public List<EvCard> findCardsByFilter(EfCard efCard) {
//        Query query = em.createQuery("select new com.bank.data.view.EVCard(cust.firstName," +
//                "cust.lastName, card.holderId, card.pan, card.CVV2, card.issueDate, card.expireDate, card.paymentApplicationTypeValue" +
//                ") from ECustomer cust left join ECard card on cust.identityNo=card.holderId " +
//                "where cust.identityNo=:holderId");
//        query.setParameter("holderId", holderId);
//        return query.getResultList();
        return null;
    }

    @Override
    public EvCard getCardFullDetails(String pan) {
        Query query = em.createQuery("select new com.bank.data.view.EvCard(contact.firstName, contact.lastName, contact.identityNo, card.pan," +
                " card.CVV2, card.issueDate, card.expireDate, card.paymentApplicationTypeValue," +
                " card.paymentApplicationNumber, contact.id, card.ownerCustomerNo)" +
                "from ECard card left join card.customer contact where card.pan = :pan");
        query.setParameter("pan", pan);
        return (EvCard) query.getSingleResult();
    }
}
