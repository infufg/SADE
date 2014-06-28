package com.sade.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Eurismar Pires Borges
 */
@Entity
public class Atividade implements Serializable, Persistable<Long> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_atividade")
    private Long id;

    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    private Area area;

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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sade.model.Atividade[ id=" + id + " ]";
    }

}
