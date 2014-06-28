package main.com.sade.dao;

import main.com.sade.model.Area;

import javax.persistence.EntityManager;

public class AreaDao extends DaoAbstrata<Area, Long> {
    public AreaDao(EntityManager entityManager) {
        super(entityManager);
    }
}
