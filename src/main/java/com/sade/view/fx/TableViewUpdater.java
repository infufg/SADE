package com.sade.view.fx;

import com.sade.model.Docente;
import com.sade.service.NotaService;
import com.sade.util.XMLParser;
import javafx.scene.control.TableView;

import java.io.File;

/**
 * Created by Vinicius on 04/07/2014.
 * Classe responsavel por ler os dados do arquivo de entrada, executar as funções de calculo e atualizar a TableView
 */
public class TableViewUpdater extends Thread {

	private TableView<ObservableDocente> tableView;
	private File arquivoSade;

	public TableViewUpdater(TableView<ObservableDocente> tableView, File arquivoSade) {

		this.tableView = tableView;
		this.arquivoSade = arquivoSade;
	}

	@Override
	public void run() {
		XMLParser xmlParser = new XMLParser(arquivoSade);

		xmlParser.start();

		while (xmlParser.temNovosDocentes()) {

			for (Docente docente : xmlParser.getNovosDocentes()) {



				ObservableDocente observableDocente = new ObservableDocente(docente);


				tableView.getItems().add(observableDocente);
			}

		}

	}

}
