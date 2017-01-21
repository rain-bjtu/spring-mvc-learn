package com.rain.learn.sms.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    protected CriteriaBuilder getCriteriaBuilder() {
        return getSession().getCriteriaBuilder();
    }

    protected <E> Query<E> createQuery(CriteriaQuery<E> cq) {
        return getSession().createQuery(cq);
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
        CriteriaBuilder builder = getCriteriaBuilder();

        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);
        criteria.where(builder.equal(root.get(path), name));

        return createQuery(criteria).getSingleResult();
    }

    public List<T> queryAll() {
        CriteriaBuilder builder = getCriteriaBuilder();

        CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
        Root<T> root = criteria.from(persistentClass);
        criteria.select(root);

        return createQuery(criteria).getResultList();
    }
}
