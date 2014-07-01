package com.sade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author eurismarpires
 */
@Entity
public class Area implements Serializable, Persistable<Long> {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_area")
	private Long id;
	@Column
	private String nome;

	@OneToMany(mappedBy = "area")
	private List<Atividade> atividades;

	@OneToMany(mappedBy = "areaPai")
	private List<Area> areas;

	@ManyToOne()
	@JoinColumn(name = "id_area_pai", referencedColumnName = "id_area")
	private Area areaPai;

	public List<Atividade> getAtividades() {

		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {

		this.atividades = atividades;
	}

	public Area(String nome, List<Atividade> atividades) {

		this.nome = nome;
		this.atividades = atividades;
	}

	public Area() {

	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public List<Area> getAreas() {

		return areas;
	}

	public void setAreas(List<Area> areas) {

		this.areas = areas;
	}

	public Area getAreaPai() {

		return areaPai;
	}

	public void setAreaPai(Area area) {

		this.areaPai = area;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (!(o instanceof Area)) return false;

		Area area = (Area) o;

		if (areaPai != null ? !areaPai.equals(area.areaPai) : area.areaPai != null) return false;
		if (areas != null ? !areas.equals(area.areas) : area.areas != null) return false;
		if (atividades != null ? !atividades.equals(area.atividades) : area.atividades != null) return false;
		if (id != null ? !id.equals(area.id) : area.id != null) return false;
		if (!nome.equals(area.nome)) return false;

		return true;
	}

	@Override
	public int hashCode() {

		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + nome.hashCode();
		result = 31 * result + (atividades != null ? atividades.hashCode() : 0);
		result = 31 * result + (areas != null ? areas.hashCode() : 0);
		result = 31 * result + (areaPai != null ? areaPai.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {

		final StringBuilder sb = new StringBuilder("Area{");
		sb.append("id=").append(id);
		sb.append(", nome='").append(nome).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
