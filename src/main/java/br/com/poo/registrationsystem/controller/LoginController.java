package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.users.Usuario;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

import static br.com.poo.registrationsystem.repository.Repositorio.buscarTodoUsuario;

public class LoginController {

    @FXML
    private Button idBtnLog;

    @FXML
    private Hyperlink idLinkLog;

    @FXML
    private PasswordField idSenhaLog;

    @FXML
    private TextField idUsuarioLog;

    @FXML
    private ImageView formaCincoLog;

    @FXML
    private ImageView formaDoisLog;

    @FXML
    private ImageView formaQuatroLog;

    @FXML
    private ImageView formaTresLog;

    @FXML
    private ImageView formaUmLog;

    List<Usuario> usuarios = buscarTodoUsuario();

    public void initialize(){

        animarFlutuacao(formaUmLog, -15, 3000);
        animarFlutuacao(formaDoisLog, 20, 2500);
        animarFlutuacao(formaTresLog, -10, 3000);
        animarFlutuacao(formaQuatroLog, 10, 2500);
        animarFlutuacao(formaCincoLog, 25, 4000);


        animarBotao();

    }

    @FXML
    public void realizarLogin(ActionEvent event) {

        String email = idUsuarioLog.getText();
        String senha = idSenhaLog.getText();


        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)
                    && usuario.getSenha().equals(senha)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText(
                        "Bem-vindo, " + usuario.getNome()
                );
            }else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(
                        "Usuário ou Senha Incorretos.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    public void linkarCadastro(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/br/com/poo/registrationsystem/view/cadastroView.fxml"
                    )
            );

            Stage stage = (Stage) idLinkLog.getScene().getWindow();

            stage.setScene(
                    new Scene(loader.load())
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void animarBotao() {
        if (idBtnLog == null) return;

        String visualBase = "-fx-background-color: #FF5E4D; -fx-background-radius: 8px; " +
                "-fx-background-insets: 1px; -fx-border-color: black; " +
                "-fx-border-width: 3px; -fx-border-radius: 8px; " +
                "-fx-font-weight: bold; -fx-text-fill: white; ";

        idBtnLog.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 6, 6);");
        idBtnLog.setTranslateX(0);
        idBtnLog.setTranslateY(0);

        idBtnLog.setOnMouseEntered(e -> {
            idBtnLog.setCursor(javafx.scene.Cursor.HAND);
            idBtnLog.setTranslateX(-2);
            idBtnLog.setTranslateY(-2);
            idBtnLog.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 8, 8);");
        });

        idBtnLog.setOnMouseExited(e -> {
            idBtnLog.setTranslateX(0);
            idBtnLog.setTranslateY(0);
            idBtnLog.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 6, 6);");
        });

        idBtnLog.setOnMousePressed(e -> {
            idBtnLog.setTranslateX(6);
            idBtnLog.setTranslateY(6);
            idBtnLog.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 0, 0);");
        });

        idBtnLog.setOnMouseReleased(e -> {
            idBtnLog.setTranslateX(-2);
            idBtnLog.setTranslateY(-2);
            idBtnLog.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 8, 8);");
        });
    }

    private void animarFlutuacao(Node node, double distancia, double duracao) {

        if (node == null) return;
        TranslateTransition transition = new TranslateTransition(Duration.millis(duracao), node);
        transition.setByY(distancia);
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setInterpolator(Interpolator.EASE_BOTH);
        transition.play();
    }

}
