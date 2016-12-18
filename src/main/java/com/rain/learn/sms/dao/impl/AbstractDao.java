package com.rain.learn.sms.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rain.learn.sms.Constants;

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }

    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public T loadByKey(PK key) {
        return (T) getSession().load(persistentClass, key);
    }

    public void save(T entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void deleteByKey(PK key) {
        Session session = getSession();
        T deleted = (T) session.load(persistentClass, key);
        session.delete(deleted);
    }

    public void bulkSave(Set<T> ebos) {
        Session session = getSession();
        int count = 0;
        for (T ebo : ebos) {
            session.saveOrUpdate(ebo);
            count++;
            if (count % Constants.BATCH_SIZE == 0) {
                session.flush();
                session.clear();
            }
        }
    }

    public T queryByName(String name, String path) {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);
        criteria.where(builder.equal(root.get(path), name));

        return em.createQuery(criteria).getSingleResult();
    }

    public List<T> queryAll() {
        EntityManager em = getEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);

        return em.createQuery(criteria).getResultList();
    }
}
