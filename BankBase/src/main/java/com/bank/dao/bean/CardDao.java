package com.bank.dao.bean;

import com.bank.data.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

import java.util.List;

public interface CardDao extends CrudRepository<Card, Long> {

    public Card findByPan(String pan);

    public List<Card> findByHolderId(Long holderId);

    public List<Card> findByPaymentApplicationNumber(String paymentApplicationNo);
}
