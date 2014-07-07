package com.sade.view.fx;

import com.sade.model.Docente;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Vinicius on 03/07/2014.
 * Encapusula o objeto que vai ser criado.
 */
public class ObservableDocente {

	private Docente docente;

    public ObservableDocente(Docente docente) {
		this.docente = docente;
    }

    public StringProperty idProperty() {
        return new SimpleStringProperty(docente.getId());
    }

    public StringProperty nomeProperty()
    {
        return new SimpleStringProperty(docente.getNome());
    }

    public DoubleProperty notaProperty() {
	    return new SimpleDoubleProperty(0);
    }
}
