package br.com.poo.registrationsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/br/com/poo/registrationsystem/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login - Sistema de Registro");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

}
