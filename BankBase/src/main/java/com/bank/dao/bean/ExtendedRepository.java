package com.bank.dao.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ExtendedRepository<T,ID> extends JpaRepository<T,ID> {
    void persist(T t);
    void merge(T t);
}
