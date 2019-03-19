package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {
    T findOne(final long id);

    List<T> findAll();

    void create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(long entityId);
}
