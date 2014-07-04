package com.sade.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Vinicius on 03/07/2014.
 * Classe que inicializa a aplicação javafx
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Sistema de Avaliação");

        try {

            FXMLLoader loader = new FXMLLoader(Main.class.getResource("ViewPrincipal.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


}
