package com.sade.view.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<ObservableDocente> tableView;
    @FXML
    private TableColumn<ObservableDocente, String> columnId;
    @FXML
    private TableColumn<ObservableDocente, String> columnNome;
    @FXML
    private TableColumn<ObservableDocente, String> columnNota;
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
        //oculta o botão de erros.
        textErros.setVisible(false);

        //configura as coluna do tableView
        configuraTableView();

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
        if(arquivoSade != null)
        {
           // progressBar = new ProgressBar(-1);
            progressBar.setProgress(-1);
            TableViewUpdater tableViewUpdater = new TableViewUpdater(tableView,arquivoSade, progressBar);
            tableViewUpdater.start();
        }
    }
    /**
     * Configura os valores para os campos da tableview
     */
    private void configuraTableView()
    {
        columnId.setCellValueFactory(new PropertyValueFactory<ObservableDocente,String>("id"));

        columnNome.setCellValueFactory(new PropertyValueFactory<ObservableDocente,String>("nome"));

        columnNota.setCellValueFactory(new PropertyValueFactory<ObservableDocente,String>("nota"));

    }



}
