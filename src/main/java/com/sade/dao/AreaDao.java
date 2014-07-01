package com.sade.dao;

import com.sade.model.Area;

import javax.persistence.EntityManager;

public class AreaDao extends DaoAbstrata<Area, Long> {

	public AreaDao(EntityManager entityManager) {

		super(entityManager);
	}
}
