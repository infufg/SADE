package com.sade.view.fx;

import com.sade.model.Docente;
import com.sade.util.XMLParser;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Vinicius on 04/07/2014.
 * Classe responsavel por ler os dados do arquivo de entrada, executar as funções de calculo e atualizar a TableView
 */
public class TableViewUpdater extends Thread {

    private TableView tableView;
    private File arquivoSade;

    public TableViewUpdater(TableView tableView, File arquivoSade) {
        this.tableView = tableView;
        this.arquivoSade = arquivoSade;
    }


    @Override
    public void run()
    {
       //TODO atualizar a table view a medida que se tem resultados do parser. Fazer isso com thread em tempo real

        XMLParser xmlParser = new XMLParser();

        try {

            //TODO um null pointer acontece hora sim hora não aqui.
            xmlParser.getDocentesXML(arquivoSade);

            while(!xmlParser.isEncerrado())
            {

                for(Docente d: xmlParser.getDocentes())
                {
                    //TODO calcular nota e settar no lugar do zero. O objeto d tem todas as atividades.
                    tableView.getItems().add(new ObservableDocente(d.getId(),d.getNome(),0));

                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
