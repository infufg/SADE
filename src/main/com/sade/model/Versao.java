package com.sade.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Eurismar Pires Borges
 */
@Entity
public class Versao implements Serializable, Persistable<Long> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_versao")
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versao)) {
            return false;
        }
        Versao other = (Versao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sade.model.Versao[ id=" + id + " ]";
    }
    
    public void validate() {
        //verifica se o periodo inicial não é superior ao final
        if (periodoInicial.compareTo(periodoFinal) > 0){
            throw new IllegalArgumentException("O período inicial não pode ser"
                    + "superior ao período final.");
        }
    }
    
}
