package com.bank.domain.business.service;

import com.bank.domain.data.entity.ECard;
import com.bank.domain.data.exception.EntityNotExistsException;
import com.bank.domain.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.domain.data.view.EvCard;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CardService {
    public com.bank.domain.data.view.EvCardIssueDetailData issueCard(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException;

    public void removeCardByCardNo(String cardNo);

    public void removeAllCardsByCardIdentityNo(String identityNo);

    EvCard getCardFullDetails(String pan);
}
