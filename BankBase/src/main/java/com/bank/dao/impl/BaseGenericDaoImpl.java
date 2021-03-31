package com.bank.dao.impl;

import com.bank.dao.bean.BaseGenericDao;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@NoRepositoryBean
public abstract class BaseGenericDaoImpl<T extends Serializable, ID extends Serializable> implements BaseGenericDao<T, ID> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> clazz;

    public BaseGenericDaoImpl() {
        clazz = ((Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    @Override
    public T save(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public void delete(T t) {
        em.remove(t);
    }

    @Override
    public List<T> findAll() {
        return ((List<T>) em.createNativeQuery("select * from " + clazz.getName()).getResultList());
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public T getReference(Object filter) {
        return em.getReference(clazz, filter);
    }

    @Override
    public List<T> find(Object filter) {
        return null;
    }

    @Override
    public T findById(ID id) {
        return em.find(clazz, id);
    }
}
