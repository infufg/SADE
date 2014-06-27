package com.sade.model;

import com.sade.model.Atividade;

import java.util.List;

/**
 * Created by Vinicius on 25/06/2014.
 * Não persistido. Utilizado para encapsular as lista de atividade de um dado docente.
 */
public class Docente {

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
}
