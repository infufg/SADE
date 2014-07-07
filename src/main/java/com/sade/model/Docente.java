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
		if(!(o instanceof Docente))
			throw new ClassCastException();
		else {
			if(nome.compareTo(((Docente) o).getNome()) != 0) {
				return nome.compareTo(((Docente) o).getNome());
			} else if(id.compareTo(((Docente) o).getId()) != 0) {
				return id.compareTo(((Docente) o).getId());
			} else {
				return 0;
			}
		}
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (!(o instanceof Docente)) return false;

		Docente docente = (Docente) o;

		if (atividades != null ? !atividades.equals(docente.atividades) : docente.atividades != null) return false;
		if (id != null ? !id.equals(docente.id) : docente.id != null) return false;
		if (nome != null ? !nome.equals(docente.nome) : docente.nome != null) return false;

		return true;
	}

	@Override
	public int hashCode() {

		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (nome != null ? nome.hashCode() : 0);
		result = 31 * result + (atividades != null ? atividades.hashCode() : 0);
		return result;
	}
}
