/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alunoinf
 */
@Entity
public class Resolucao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idResolucao;
    @Column
    @Temporal(value=TemporalType.DATE)
    private Calendar periodo_Inicial;
    @Column
    @Temporal(value=TemporalType.DATE)    
    private Calendar periodo_Final;
    @Column(length = 10)
    private String codigo_Resolucao;
    @OneToMany(mappedBy = "resolucao")
    private List<Atividade> atividades;
    public Long getIdResolucao() {
        return idResolucao;
    }

    public void setIdResolucao(Long id) {
        this.idResolucao = id;
    }

    public Calendar getPeriodo_Inicial() {
        return periodo_Inicial;
    }

    public void setPeriodo_Inicial(Calendar periodo_Inicial) {
        this.periodo_Inicial = periodo_Inicial;
    }

    public Calendar getPeriodo_Final() {
        return periodo_Final;
    }

    public void setPeriodo_Final(Calendar periodo_Final) {
        this.periodo_Final = periodo_Final;
    }

    public String getCodigo_Resolucao() {
        return codigo_Resolucao;
    }

    public void setCodigo_Resolucao(String codigo_Resolucao) {
        this.codigo_Resolucao = codigo_Resolucao;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResolucao != null ? idResolucao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resolucao)) {
            return false;
        }
        Resolucao other = (Resolucao) object;
        if ((this.idResolucao == null && other.idResolucao != null) || (this.idResolucao != null && !this.idResolucao.equals(other.idResolucao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sade.model.Resolucao[ id=" + idResolucao + " ]";
    }
    
}
