package com.bank.serviceImpl;

import com.bank.business.card.CardBusinessFactory;
import com.bank.business.card.IssueCardBusiness;
import com.bank.data.entity.ECard;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service(value = "CardService")
public class CardServiceImpl implements CardService {
    private IssueCardBusiness issueCardBusiness;

    @Autowired
    CardServiceImpl(CardBusinessFactory cardBusinessFactory) {
        this.issueCardBusiness = cardBusinessFactory.getIssueCardBusiness();
    }

    @Override
    public ECard saveCard(ECard card) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, SQLException {
        return issueCardBusiness.execute(card);
    }

    @Override
    public void removeCardByCardNo(String cardNo) {

    }

    @Override
    public void removeAllCardsByCardIdentityNo(String identityNo) {

    }
}
