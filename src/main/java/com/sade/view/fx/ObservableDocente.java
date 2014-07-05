package com.sade.view.fx;

import javafx.beans.property.*;

/**
 * Created by Vinicius on 03/07/2014.
 * Encapusula o objeto que vai ser criado.
 */
public class ObservableDocente {

    private StringProperty id;
    private StringProperty nome;
    private DoubleProperty nota;

    public ObservableDocente(String id, String nome, double nota) {

        this.id = new SimpleStringProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.nota = new SimpleDoubleProperty(nota);

    }

    public StringProperty idProperty()
    {
        return id;
    }

    public StringProperty nomeProperty()
    {
        return nome;
    }

    public DoubleProperty notaProperty() {return nota;}

    //getters e setters comuns
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.setValue(nome);
    }

    public double getNota() {
        return nota.get();
    }

    public void setNota(double nota) {
        this.nota.setValue(nota);
    }


}
