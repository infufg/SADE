package com.sade.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author eurismarpires
 */
@Entity
public class Atividade implements Serializable, Persistable<Long> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_area", referencedColumnName = "id_area")
	private Area area;

	@ManyToOne
	@JoinColumn(name = "id_versao", referencedColumnName = "id_versao")
	private Versao versao;

	@Column
	private String nome;

	@Column
	private String codigo;

	@Column(name = "limite_pontuacao")
	private String descricao;

	@Column
	private Double pontuacao;

	@Column
	private Double limitePontuacao;

	@Column
	private Integer quantidade;

	@Column
	private Integer divisor;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public Area getArea() {

		return area;
	}

	public void setArea(Area area) {

		this.area = area;
	}

	public Versao getVersao() {

		return versao;
	}

	public void setVersao(Versao versao) {

		this.versao = versao;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getCodigo() {

		return codigo;
	}

	public void setCodigo(String codigo) {

		this.codigo = codigo;
	}

	public String getDescricao() {

		return descricao;
	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	public Double getLimitePontuacao() {

		return limitePontuacao;
	}

	public void setLimitePontuacao(Double limitePontuacao) {

		this.limitePontuacao = limitePontuacao;
	}

	public Double getPontuacao() {

		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {

		this.pontuacao = pontuacao;
	}

	public Integer getQuantidade() {

		return quantidade;
	}

	public void setQuantidade(int quantidade) {

		this.quantidade = quantidade;
	}

	public Integer getDivisor() {

		return divisor;
	}

	public void setDivisor(Integer divisor) {

		this.divisor = divisor;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (!(o instanceof Atividade)) return false;

		Atividade atividade = (Atividade) o;

		if (!area.equals(atividade.area)) return false;
		if (!codigo.equals(atividade.codigo)) return false;
		if (!descricao.equals(atividade.descricao)) return false;
		if (divisor != null ? !divisor.equals(atividade.divisor) : atividade.divisor != null) return false;
		if (limitePontuacao != null ? !limitePontuacao.equals(atividade.limitePontuacao) : atividade.limitePontuacao != null)
			return false;
		if (!nome.equals(atividade.nome)) return false;
		if (!pontuacao.equals(atividade.pontuacao)) return false;
		if (!quantidade.equals(atividade.quantidade)) return false;
		if (!versao.equals(atividade.versao)) return false;

		return true;
	}

	@Override
	public int hashCode() {

		int result = area.hashCode();
		result = 31 * result + versao.hashCode();
		result = 31 * result + nome.hashCode();
		result = 31 * result + codigo.hashCode();
		result = 31 * result + descricao.hashCode();
		result = 31 * result + pontuacao.hashCode();
		result = 31 * result + (limitePontuacao != null ? limitePontuacao.hashCode() : 0);
		result = 31 * result + quantidade.hashCode();
		result = 31 * result + (divisor != null ? divisor.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {

		final StringBuilder sb = new StringBuilder("Atividade{");
		sb.append("id=").append(id);
		sb.append(", area=").append(area);
		sb.append(", versao=").append(versao);
		sb.append(", nome='").append(nome).append('\'');
		sb.append(", codigo='").append(codigo).append('\'');
		sb.append(", descricao='").append(descricao).append('\'');
		sb.append(", pontuacao=").append(pontuacao);
		sb.append(", limitePontuacao=").append(limitePontuacao);
		sb.append(", quantidade=").append(quantidade);
		sb.append(", divisor=").append(divisor);
		sb.append('}');
		return sb.toString();
	}
}
