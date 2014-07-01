package com.sade.dao;

import com.sade.model.Atividade;

import javax.persistence.EntityManager;

public class AtividadeDao extends DaoAbstrata<Atividade, Long> {

	public AtividadeDao(EntityManager entityManager) {

		super(entityManager);
	}
}
