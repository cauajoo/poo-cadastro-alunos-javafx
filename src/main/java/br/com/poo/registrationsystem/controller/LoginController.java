package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

import static com.sun.javafx.scene.control.skin.FXVK.init;

public class LoginController {

    @FXML
    private Button idBtnLog;

    @FXML
    private Hyperlink idLinkLog;

    @FXML
    private PasswordField idSenhaLog;

    @FXML
    private TextField idUsuarioLog;

    private List<Usuario> usuarios;

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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

}
