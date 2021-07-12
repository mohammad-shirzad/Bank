package com.bank.dao.bean;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ExtendedRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements ExtendedRepository<T,ID> {
    @PersistenceContext
    private EntityManager em;

    public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    public ExtendedRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public void persist(T t) {
        em.persist(t);
    }

    @Override
    public void merge(T t) {
        em.merge(t);
    }
}
