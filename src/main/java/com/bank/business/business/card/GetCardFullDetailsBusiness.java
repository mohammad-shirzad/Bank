package com.bank.business.business.card;

import com.bank.dao.CardDao;
import com.bank.data.view.EvCard;
import org.springframework.stereotype.Component;

@Component
public class GetCardFullDetailsBusiness {
    private CardDao cardDao;
    public GetCardFullDetailsBusiness(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public EvCard execute(String pan) {
        return cardDao.getByPan(pan);
    }
}
