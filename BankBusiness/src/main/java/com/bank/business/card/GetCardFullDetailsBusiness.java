package com.bank.business.card;

import com.bank.dao.bean.CardDao;
import com.bank.dao.factory.DaoFactory;
import com.bank.data.view.EvCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class GetCardFullDetailsBusiness {
    private CardDao cardDao;

    @Autowired
    public GetCardFullDetailsBusiness(DaoFactory daoFactory) {
        cardDao = daoFactory.getCardDao();
    }

    public EvCard execute(String pan) {
        return cardDao.getCardFullDetails(pan);
    }
}
