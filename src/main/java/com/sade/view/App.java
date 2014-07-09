package com.sade.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * Created by Vinicius on 03/07/2014.
 * Classe que inicializa a aplicação javafx
 */
public class App extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {

       primaryStage.setTitle("Sistema de Avaliação");

        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("fx/ViewPrincipal.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.show();

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    System.out.println("Stage Fechando");
                    primaryStage.close();
                }
            });



        } catch (IOException e) {

            e.printStackTrace();

        }

    }

	public static void main(String[] args) {
		launch(args);
	}


}
