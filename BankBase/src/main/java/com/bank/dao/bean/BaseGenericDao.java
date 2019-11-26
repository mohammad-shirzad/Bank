package com.bank.dao.bean;

import java.util.List;

public interface BaseGenericDao<T> {
    public T save(T t);

    public void delete(T t);

    public List<T> findAll();

    public List<T> find(Object filter);

    public void update(T t);

    public T getReference(Object filter);

}
