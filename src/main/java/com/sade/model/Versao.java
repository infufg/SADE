package com.sade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * @author eurismarpires
 */
@Entity
public class Versao implements Serializable, Persistable<Long> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_versao")
	private Long id;

	@OneToMany(mappedBy = "versao")
	private List<Atividade> atividades;

	@Column(name = "periodo_inicial")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Calendar periodoInicial;
	@Column(name = "periodo_final")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Calendar periodoFinal;
	@Column(name = "codigo_versao")
	private String codigoVersao;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public List<Atividade> getAtividades() {

		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {

		this.atividades = atividades;
	}

	public Calendar getPeriodoInicial() {

		return periodoInicial;
	}

	public void setPeriodoInicial(Calendar periodoInicial) {

		this.periodoInicial = periodoInicial;
	}

	public Calendar getPeriodoFinal() {

		return periodoFinal;
	}

	public void setPeriodoFinal(Calendar periodoFinal) {

		this.periodoFinal = periodoFinal;
	}

	public String getCodigoVersao() {

		return codigoVersao;
	}

	public void setCodigoVersao(String codigoVersao) {

		this.codigoVersao = codigoVersao;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (!(o instanceof Versao)) return false;

		Versao versao = (Versao) o;

		if (!codigoVersao.equals(versao.codigoVersao)) return false;
		if (periodoFinal != null ? !periodoFinal.equals(versao.periodoFinal) : versao.periodoFinal != null)
			return false;
		if (periodoInicial != null ? !periodoInicial.equals(versao.periodoInicial) : versao.periodoInicial != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {

		int result = periodoInicial != null ? periodoInicial.hashCode() : 0;
		result = 31 * result + (periodoFinal != null ? periodoFinal.hashCode() : 0);
		result = 31 * result + codigoVersao.hashCode();
		return result;
	}

	@Override
	public String toString() {

		final StringBuilder sb = new StringBuilder("Versao{");
		sb.append("id=").append(id);
		sb.append(", periodoInicial=").append(periodoInicial != null ? periodoInicial.getTime() : "Sem Início");
		sb.append(", periodoFinal=").append(periodoFinal != null ? periodoFinal.getTime() : "Sem Fim");
		sb.append(", codigoVersao='").append(codigoVersao).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
