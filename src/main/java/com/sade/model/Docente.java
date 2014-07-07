package com.sade.model;

import com.sade.service.NotaService;

import java.util.List;

/**
 * Created by viniciusmaboni
 * Não persistido. Utilizado para encapsular as lista de atividade de um dado docente.
 */
public class Docente implements Comparable {

	private String id;
	private String nome;
	private List<Atividade> atividades;

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public List<Atividade> getAtividades() {

		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {

		this.atividades = this.atividades;
	}

	public double getNota() {
		return new NotaService().calculeNota(atividades).doubleValue();
	}

	@Override
	public int compareTo(Object o) {
		return this.nome.compareTo(((Docente)o).getNome());
	}
}
