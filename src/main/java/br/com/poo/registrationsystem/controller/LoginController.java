package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.users.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    List<Usuario> usuarios = buscarTodoUsuario();

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
}
