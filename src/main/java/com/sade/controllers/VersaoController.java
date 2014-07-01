package com.sade.controllers;

import com.sade.model.Versao;
import com.sade.service.VersaoService;

import java.util.List;

/**
 * @author jullianonascimento
 */
public class VersaoController {

	public Versao save(Versao versao) {

		return new VersaoService().save(versao);
	}

	public Versao update(Versao versao) {

		return new VersaoService().update(versao);
	}

	public boolean delete(Versao versao) {

		return new VersaoService().delete(versao);
	}

	public List<Versao> list() {

		return new VersaoService().list();
	}

	public Versao get(Long idVersao) {

		return new VersaoService().get(idVersao);
	}
}

