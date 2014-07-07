package com.sade.view.fx;

import com.sade.model.Atividade;
import com.sade.model.Docente;
import com.sade.service.NotaService;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.math.BigDecimal;

/**
 * Created by Vinicius on 03/07/2014.
 * Encapusula o objeto que vai ser criado.
 */
public class ObservableDocente {

	private Docente docente;
    private DoubleProperty notaDoubleProperty;


    public ObservableDocente(Docente docente) {

		this.docente = docente;

        //calcula a nota do docente
        NotaService notaService = new NotaService();

        double result = 0;
        for(Atividade a: docente.getAtividades()) {

           result += notaService.calculaNotaDeAtividade(a).doubleValue();

        }

        notaDoubleProperty.setValue(result);


    }

    public StringProperty idProperty() {
        return new SimpleStringProperty(docente.getId());
    }

    public StringProperty nomeProperty()
    {
        return new SimpleStringProperty(docente.getNome());
    }

    public DoubleProperty notaProperty() {
	    return notaDoubleProperty;
    }
}
