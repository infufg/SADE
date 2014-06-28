package com.sade.dao;

import com.sade.model.Persistable;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/*
    Base: http://wehavescience.com/2013/02/24/criando-um-dao-generico-com-hibernate/
*/
abstract class DaoAbstrata<T extends Persistable<PK>, PK> implements Dao<T, PK> {
    private EntityManager entityManager;

    public DaoAbstrata(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T save(T obj) {
        entityManager.persist(obj);
        return get(obj.getId());
    }

    public T update(T obj) {
        return entityManager.merge(obj);
    }

    public boolean delete(T obj) {
        entityManager.remove(obj);
        return true;
    }

    public List<T> list() {
        return (List<T>) entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    public T get(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
