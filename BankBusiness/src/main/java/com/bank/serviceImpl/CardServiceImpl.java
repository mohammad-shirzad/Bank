package com.bank.serviceImpl;

import com.bank.business.card.GetCardFullDetailsBusiness;
import com.bank.business.card.IssueCardBusiness;
import com.bank.data.entity.ECard;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.view.EvCard;
import com.bank.service.CardService;
import org.springframework.stereotype.Service;

@Service(value = "CardService")
public class CardServiceImpl implements CardService {

    @Override
    public ECard saveCard(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException {
        return new IssueCardBusiness().execute(card);
    }

    @Override
    public void removeCardByCardNo(String cardNo) {

    }

    @Override
    public void removeAllCardsByCardIdentityNo(String identityNo) {

    }

    @Override
    public EvCard getCardFullDetails(String pan) {
        return new GetCardFullDetailsBusiness().execute(pan);
    }
}
