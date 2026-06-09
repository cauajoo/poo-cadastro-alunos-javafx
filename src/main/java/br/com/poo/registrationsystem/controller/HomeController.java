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
    private ImageView idImgSair;

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

    @FXML
    private void mediasAlunos() {
        carregarPagina("mediasAlunosView.fxml");
    }

    @FXML
    private void cadastrarAlunos() {
        carregarPagina("cadastroAlunoView.fxml");
    }

    @FXML
    private void alunosCadastrados() {
        carregarPagina("alunosView.fxml");
    }

    @FXML
    private void cadastrarNotas() {
        carregarPagina("cadastroNotasView.fxml");
    }

    @FXML
    private void realizarLogout() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/poo/registrationsystem/view/loginView.fxml"));
            Parent root = loader.load();

            Stage stageAtual = (Stage) idImgSair.getScene().getWindow();

            stageAtual.setScene(new Scene(root));
            stageAtual.setTitle("Login - Sistema de Registro");
            stageAtual.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao realizar logout: " + e.getMessage());
        }
    }




}
