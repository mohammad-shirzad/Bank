package com.bank.business.card;

import com.bank.dao.bean.CardDao;
import com.bank.data.view.EvCard;

import java.util.Collections;

public class GetCardFullDetailsBusiness {
    private CardDao cardDao;
    public GetCardFullDetailsBusiness(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public EvCard execute(String pan) {
        return cardDao.getByPan(pan);
    }
}
