package com.sade.dao;

import com.sade.model.Area;
import com.sade.model.Persistable;
<<<<<<< HEAD
=======

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
>>>>>>> upstream/master
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

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
<<<<<<< HEAD
                return obj;
		//return get(obj.getId());
=======

		entityManager.flush();
		transaction.commit();
		return get(obj.getId());
>>>>>>> upstream/master
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
