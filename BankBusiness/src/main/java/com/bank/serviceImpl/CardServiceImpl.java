package com.bank.serviceImpl;

import com.bank.business.card.CardBusinessFactory;
import com.bank.business.card.GetCardFullDetailsBusiness;
import com.bank.business.card.IssueCardBusiness;
import com.bank.data.entity.ECard;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.view.EvCard;
import com.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service(value = "CardService")
public class CardServiceImpl implements CardService {
    private IssueCardBusiness issueCardBusiness;
    private GetCardFullDetailsBusiness getCardFullDetailsBusiness;

    @Autowired
    CardServiceImpl(CardBusinessFactory cardBusinessFactory) {
        this.issueCardBusiness = cardBusinessFactory.getIssueCardBusiness();
        this.getCardFullDetailsBusiness = cardBusinessFactory.getGetCardFullDetailsBusiness();
    }

    @Override
    public ECard saveCard(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        return issueCardBusiness.execute(card);
    }

    @Override
    public void removeCardByCardNo(String cardNo) {

    }

    @Override
    public void removeAllCardsByCardIdentityNo(String identityNo) {

    }

    @Override
    public EvCard getCardFullDetails(String pan) {
        return getCardFullDetailsBusiness.execute(pan);
    }
}
