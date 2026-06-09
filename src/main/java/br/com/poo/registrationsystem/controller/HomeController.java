package br.com.poo.registrationsystem.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button idBtmAluno;

    @FXML
    private Button idBtmCadAluno;

    @FXML
    private Button idBtmCadNota;
    @FXML
    private Button idBtmMed;

    @FXML
    private ImageView idImgPerfil;

    @FXML
    private Button idImgSair;

    @FXML
    private AnchorPane idTela;

    @FXML
    private void carregarPagina(String arquivoFxml) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/poo/registrationsystem/" + arquivoFxml));
            Parent root = loader.load();

            idTela.getChildren().clear();

            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);

            idTela.getChildren().add(root);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a página: " + arquivoFxml);
        }
    }

    private void alterarBotaoAtivo(Button botaoAtivo) {

        idBtmCadNota.getStyleClass().setAll("button", "botao-menu");
        idBtmMed.getStyleClass().setAll("button", "botao-menu");
        idBtmAluno.getStyleClass().setAll("button", "botao-menu");

        idBtmCadAluno.getStyleClass().setAll("button", "botao-destaque");

        if (botaoAtivo == idBtmCadAluno) {

            idBtmCadAluno.getStyleClass().setAll("button", "botao-destaque");

        } else if (botaoAtivo != null) {

            botaoAtivo.getStyleClass().setAll("button", "botao-menu-ativo");

        }
    }

    @FXML
    private void cadastrarAlunos() {
        alterarBotaoAtivo(idBtmCadAluno);
        carregarPagina("cadastroAlunoView.fxml");
    }

    @FXML
    private void cadastrarNotas() {
        alterarBotaoAtivo(idBtmCadNota);
        carregarPagina("cadastroNotasView.fxml");
    }

    @FXML
    private void mediasAlunos() {
        alterarBotaoAtivo(idBtmMed);
        carregarPagina("mediasAlunosView.fxml");
    }

    @FXML
    private void alunosCadastrados() {
        alterarBotaoAtivo(idBtmAluno);
        carregarPagina("alunosView.fxml");
    }

    @FXML
    private void realizarLogout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/poo/registrationsystem/loginView.fxml"));
            Parent root = loader.load();

            Stage stageAtual = (Stage) idImgSair.getScene().getWindow();

            stageAtual.setScene(new Scene(root));
            stageAtual.setTitle("Login - Sistema de Registro");
            stageAtual.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao realizar logout: " + e.getMessage());
        }
    }




}
