package com.sade.dao;

import com.sade.model.Versao;

import javax.persistence.EntityManager;

public class VersaoDao extends DaoAbstrata<Versao, Long> {
    public VersaoDao(EntityManager entityManager) {
        super(entityManager);
    }
}
