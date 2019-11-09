package com.bank.dao.bean;

import com.bank.data.entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface TransactionDao extends CrudRepository<Transaction, Long> {
}
