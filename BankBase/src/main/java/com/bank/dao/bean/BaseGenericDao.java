package com.bank.dao.bean;

import java.sql.SQLException;
import java.util.List;

public interface BaseGenericDao<T> {
    public T save(T t);

    public void delete(T t);

    public List<T> findAll();

    public List<T> find(Object filter) throws SQLException;

    public void update(T t);

    public T getReference(Object filter);

}
