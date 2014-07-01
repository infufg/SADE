package com.sade.service;

import com.sade.dao.VersaoDao;
import com.sade.model.Versao;

import java.util.List;

/**
 * @author jullianonascimento
 */
public class VersaoService {

	private VersaoDao dao;

	public VersaoService() {

		dao = new VersaoDao();
	}

	public Versao save(Versao versao) {

		return dao.save(versao);

	}

	public Versao update(Versao versao) {

		return dao.update(versao);

	}

	public boolean delete(Versao versao) {

		return dao.delete(versao);
	}

	public List<Versao> list() {

		return dao.list();
	}

	public Versao get(Long idVersao) {

		return dao.get(idVersao);
	}
}
