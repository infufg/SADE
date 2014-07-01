package com.sade.dao;

import com.sade.model.Area;
import com.sade.model.Persistable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

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
                return obj;
		//return get(obj.getId());
	}

	public T update(T obj) {

		return entityManager.merge(obj);
	}

	public boolean delete(T obj) {

		entityManager.remove(obj);
		return true;
	}

	public List<T> list() {

		return (List<T>) entityManager.createQuery(("select c FROM " + getTypeClass().getName() + " c ")).getResultList();
	}

	public T get(PK pk) {

	return (T) entityManager.find(getTypeClass(), pk);
          //  return (T) entityManager.find(Area.class, pk);
	}

	private Class<?> getTypeClass() {

		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}
}
