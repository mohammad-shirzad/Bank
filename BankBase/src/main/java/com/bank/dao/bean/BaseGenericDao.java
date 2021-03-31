package com.bank.dao.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface BaseGenericDao<T, ID extends Serializable> {
    public T save(T t);

    public void delete(T t);

    public List<T> findAll();

    public List<T> find(Object filter);

    T findById(ID id);

    public void update(T t);

    public T getReference(Object filter);

}
