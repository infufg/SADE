package com.sade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Eurismar Pires Borges
 */
@Entity
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_area")
    private Long id;
    @Column
    private String nome;
    
    @OneToMany(mappedBy = "area")
    private List<Atividade> atividades;

    @OneToMany(mappedBy = "area")
    private List<Area> areas;
    
    @ManyToOne()
    @JoinColumn(name = "id_area_pai",referencedColumnName = "id_area")
    private Area area;
    
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sade.model.Area[ id=" + id + " ]";
    }
    
}
