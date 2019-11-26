package com.bank.dao.impl;

import com.bank.dao.bean.CardDao;
import com.bank.data.entity.ECard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "CardDao")
public class CardDaoImpl extends BaseGenericDaoImpl<ECard> implements CardDao {
    @Override
    public List<ECard> find(Object filter) {
        return null;
    }
}
