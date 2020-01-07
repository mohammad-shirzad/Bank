package com.bank.business.card;

import com.bank.dao.bean.CardDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECard;
import com.bank.data.exception.EntityAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class IssueCardBusiness {

    private CardDao cardDao;

    @Autowired
    IssueCardBusiness(DaoFactory daoFactory) {
        this.cardDao = daoFactory.getCardDao();
    }

    public void validate(ECard card) throws EntityAlreadyExistsException {
        ECard dbCard = cardDao.find(card).get(0);
        if (dbCard != null)
            throw new EntityAlreadyExistsException("There already a card with the same cardNo exists");


    }

    public ECard doBusiness(ECard card) {
        card.setLastModificationDate(Calendar.getInstance().getTime());
        return cardDao.save(card);
    }

    public ECard execute(ECard card) throws EntityAlreadyExistsException {
        validate(card);
        return doBusiness(card);
    }
}
