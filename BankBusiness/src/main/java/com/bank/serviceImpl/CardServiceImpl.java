package com.bank.serviceImpl;

import com.bank.business.card.GetCardFullDetailsBusiness;
import com.bank.business.card.IssueCardBusiness;
import com.bank.business.factory.BusinessFactory;
import com.bank.data.entity.ECard;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.view.EvCard;
import com.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CardService")
public class CardServiceImpl implements CardService {
    private IssueCardBusiness issueCardBusiness;
    private GetCardFullDetailsBusiness getCardFullDetailsBusiness;

    @Autowired
    CardServiceImpl(BusinessFactory businessFactory) {
        this.issueCardBusiness = businessFactory.getIssueCardBusiness();
        this.getCardFullDetailsBusiness = businessFactory.getGetCardFullDetailsBusiness();
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
