package com.bank.service;

import com.bank.data.entity.ECard;
import com.bank.data.exception.EntityAlreadyExistsException;
import com.bank.data.exception.EntityNotExistsException;
import com.bank.data.exception.HolderException;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional
public interface CardService {
    public ECard saveCard(ECard card) throws EntityNotExistsException, EntityAlreadyExistsException, HolderException, SQLException;

    public void removeCardByCardNo(String cardNo);

    public void removeAllCardsByCardIdentityNo(String identityNo);
}
