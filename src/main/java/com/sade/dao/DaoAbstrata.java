package com.sade.dao;

import com.sade.model.Persistable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/*
    Base: http://wehavescience.com/2013/02/24/criando-um-dao-generico-com-hibernate/
*/
abstract class DaoAbstrata<T extends Persistable<PK>, PK> implements Dao<T, PK> {

	private EntityManager entityManager;

	public DaoAbstrata() {
		String persistenceUnitName = "SADEPU";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.entityManager = factory.createEntityManager();
	}

	public T save(T obj) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.persist(obj);

		entityManager.flush();
		transaction.commit();
		return get(obj.getId());
	}

	public T update(T obj) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.merge(obj);

		entityManager.flush();
		transaction.commit();
		return get(obj.getId());
	}

	public boolean delete(T obj) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.remove(obj);

		entityManager.flush();
		transaction.commit();
		return true;
	}

	public List<T> list() {

		return (List<T>) entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	public T get(PK pk) {

		return (T) entityManager.find(getTypeClass(), pk);
	}

	private Class<?> getTypeClass() {

		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}
}
