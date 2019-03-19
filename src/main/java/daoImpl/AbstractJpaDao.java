package daoImpl;

import dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractJpaDao<T extends Serializable> implements GenericDao<T> {
    private Class<T> clazz;
    EntityManagerFactory emf;

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AbstractJpaDao() {
        this.clazz = (Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findOne(long id) {
        return (T) getEntityManager().find(clazz, id);
    }

    public List<T> findAll() {
        return getEntityManager().createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public void deleteById(long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }

}
