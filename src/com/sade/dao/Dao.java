package com.sade.dao;

import com.sade.model.Persistable;

import java.util.List;

/**
 *
 * @author Eurismar e Mauro
 */
public interface Dao<T extends Persistable<PK>, PK> {
    public T save(T obj);
    public T update(T obj);
    public boolean delete(T obj);
    public List<T> list();
    public T get(PK key);
}
