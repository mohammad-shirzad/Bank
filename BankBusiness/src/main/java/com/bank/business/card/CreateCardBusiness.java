package com.bank.business.card;

import com.bank.dao.bean.CardDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.entity.ECard;
import com.bank.data.exception.CustomerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class CreateCardBusiness {

    private CardDao cardDao;

    @Autowired
    CreateCardBusiness(DaoFactory daoFactory) {
        this.cardDao = daoFactory.getCardDao();
    }

    public void validate(ECard card) throws CustomerAlreadyExistsException {
        ECard dbCard = cardDao.find(card).get(0);
    }

    public ECard doBusiness(ECard card) {
        card.setLastModificationDate(Calendar.getInstance().getTime());
        return cardDao.save(card);
    }

    public ECard execute(ECard card) throws CustomerAlreadyExistsException {
        validate(card);
        return doBusiness(card);
    }
}
