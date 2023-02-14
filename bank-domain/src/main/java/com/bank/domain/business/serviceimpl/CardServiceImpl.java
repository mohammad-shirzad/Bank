package com.bank.domain.business.serviceimpl;

import com.bank.domain.business.card.GetCardFullDetailsBusiness;
import com.bank.domain.business.card.IssueCardBusiness;
import com.bank.domain.business.service.CardService;
import com.bank.domain.data.entity.ECard;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.domain.data.view.EvCard;
import com.bank.domain.data.view.EvCardIssueDetailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "CardService")
public class CardServiceImpl implements CardService {
    private IssueCardBusiness issueCardBusiness;
    private GetCardFullDetailsBusiness getCardFullDetailsBusiness;
    @Autowired
    public void setIssueCardBusiness(IssueCardBusiness issueCardBusiness) {
        this.issueCardBusiness = issueCardBusiness;
    }
    @Autowired
    public void setGetCardFullDetailsBusiness(GetCardFullDetailsBusiness getCardFullDetailsBusiness) {
        this.getCardFullDetailsBusiness = getCardFullDetailsBusiness;
    }

    @Override
    public EvCardIssueDetailData issueCard(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
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
