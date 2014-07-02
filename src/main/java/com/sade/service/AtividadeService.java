package com.sade.service;

import com.sade.dao.AtividadeDao;
import com.sade.model.Atividade;

import java.util.List;

/**
 * @author jullianonascimento
 */
public class AtividadeService {

	private AtividadeDao dao;

	public AtividadeService() {

		dao = new AtividadeDao();
	}

	public Atividade save(Atividade atividade) {

		return dao.save(atividade);

	}

	public Atividade update(Atividade atividade) {

		return dao.update(atividade);
	}

	public boolean delete(Atividade atividade) {

		return dao.delete(atividade);

	}

	public List<Atividade> list() {

		return dao.list();
	}

	public Atividade get(Long idAtividade) {

		return dao.get(idAtividade);
	}
}

