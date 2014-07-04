package com.sade.controllers;

import com.sade.dao.Docente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by Vinicius on 03/07/2014.
 * Essa classe é responsavel por controlar os comandos da interface grafica.
 */
public class ViewPrincipalController {


    //variaveis do fxml
    @FXML
    private Text textErros;
    @FXML
    private ProgressBar progressBar; //será atulizada a partir da quantidade de professores avaliados.
    @FXML
    private ListView<Docente> listView;
    @FXML
    private TextField textFieldPathArquivo;

    //variaveis internas
    private File arquivoSade;


    /**
     * Este metodo é quem inicializa as variaveis do fxml.
     * É executado depois do construtor.
     */
    @FXML
    private void initialize() {

        textErros.setVisible(false);

    }


    /**
     * Evento invocado pelo botão abrir arquivo.
     * @param event
     */
    @FXML
    private void handleButtonAbrirArquivoAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo Sade","*.sade"));

        arquivoSade = fileChooser.showOpenDialog(null);

        textFieldPathArquivo.setText(arquivoSade.getPath());

    }

    /**
     * Evento invocado pelo botão iniciar
     *
     * @param event
     */
    @FXML
    private void handleButtonIniciarAction(ActionEvent event)
    {



    }



}
