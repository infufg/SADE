package com.sade.dao;

import java.util.List;

/**
 *
 * @author Eurismar e Mauro
 */
public interface Dao<T> {
    public T save(T obj);
    public T update(T obj);
    public boolean delete(T obj);
    public List<T> list();
}
