package com.sade.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Eurismar Pires Borges
 */
@Entity
public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column()
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAtividade;
    @Column(length = 128, nullable = false)
    private String nome;
    @Column(length = 20)
    private String codigo;
    @Column
    private String descricao;
    @Column
    private Double pontuacao;

    
    @ManyToOne
    private Resolucao resolucao;
    
    public Long getIdAtividade() {
        return idAtividade;
    }

    public void setIdArea(Long idArea) {
        this.idAtividade = idArea;
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

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Resolucao getResolucao() {
        return resolucao;
    }

    public void setResolucao(Resolucao resolucao) {
        this.resolucao = resolucao;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtividade != null ? idAtividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.idAtividade == null && other.idAtividade != null) || (this.idAtividade != null && !this.idAtividade.equals(other.idAtividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sade.model.Atividade[ id=" + idAtividade + " ]";
    }
}
