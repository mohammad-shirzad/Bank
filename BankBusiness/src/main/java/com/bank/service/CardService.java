package com.bank.service;

import com.bank.data.entity.ECard;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import com.bank.data.exception.PaymentApplicationTypeNotSupportCardWithoutHolderException;
import com.bank.data.view.EvCard;
import com.bank.data.view.EvCardIssueDetailData;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional
public interface CardService {
    public EvCardIssueDetailData issueCard(ECard card) throws EntityNotExistsException, PaymentApplicationTypeNotSupportCardWithoutHolderException;

    public void removeCardByCardNo(String cardNo);

    public void removeAllCardsByCardIdentityNo(String identityNo);

    EvCard getCardFullDetails(String pan);
}
