package com.bank.dao.bean;

import com.bank.data.entity.ECard;
import com.bank.data.filter.EfCard;
import com.bank.data.view.EvCard;

import java.util.List;

public interface CardDao extends BaseGenericDao<ECard> {
    public List<EvCard> findCardsByFilter(EfCard efCard);

    EvCard getCardFullDetails(String pan);
}
