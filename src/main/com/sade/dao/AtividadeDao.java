package main.com.sade.dao;

import main.com.sade.model.Atividade;

import javax.persistence.EntityManager;

public class AtividadeDao extends DaoAbstrata<Atividade, Long> {
    public AtividadeDao(EntityManager entityManager) {
        super(entityManager);
    }
}
