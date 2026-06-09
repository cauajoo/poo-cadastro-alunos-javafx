package br.com.poo.registrationsystem.controller;

import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import br.com.poo.registrationsystem.validation.Validacoes;
import br.com.poo.registrationsystem.users.Usuario;
import br.com.poo.registrationsystem.repository.Repositorio;

import java.io.IOException;

public class CadastroController {

    @FXML
    private ImageView formaDoisCad;

    @FXML
    private ImageView formaQuatroCad;

    @FXML
    private ImageView formaTresCad;

    @FXML
    private ImageView formaUmCad;

    @FXML
    private Button idBtmCad;

    @FXML
    private PasswordField idConfirmCad;

    @FXML
    private TextField idCpfCad;

    @FXML
    private DatePicker idDataCad;

    @FXML
    private TextField idEmailCad;

    @FXML
    private TextField idNomeCad;

    @FXML
    private PasswordField idSenhaCad;

    @FXML
    private TextField idTelefoneCad;

    @FXML
    private ImageView logoCad;

    @FXML
    private Label msgErroLog;

    public void initialize() {

        animarFlutuacao(formaUmCad, -15, 3000);
        animarFlutuacao(formaDoisCad, 20, 2500);
        animarFlutuacao(formaTresCad, -10, 3000);
        animarFlutuacao(formaQuatroCad, 10, 2500);

        animarBotao();

        validaEmTempoReal();

        configurarClickNaLogo();


    }

    private void animarBotao() {
        if (idBtmCad == null) return;

        String visualBase = "-fx-background-color: #FF5E4D; -fx-background-radius: 8px; " +
                "-fx-background-insets: 1px; -fx-border-color: black; " +
                "-fx-border-width: 3px; -fx-border-radius: 8px; " +
                "-fx-font-weight: bold; -fx-text-fill: white; ";

        idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 5, -5);");

        idBtmCad.setOnMouseEntered(e -> {
            idBtmCad.setCursor(javafx.scene.Cursor.HAND);
            idBtmCad.setTranslateX(-3);
            idBtmCad.setTranslateY(3);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 8, -8);");
        });

        idBtmCad.setOnMouseExited(e -> {
            idBtmCad.setTranslateX(0);
            idBtmCad.setTranslateY(0);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 5, -5);");
        });

        idBtmCad.setOnMousePressed(e -> {
            idBtmCad.setTranslateX(5);
            idBtmCad.setTranslateY(-5);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 0, 0);");
        });

        idBtmCad.setOnMouseReleased(e -> {
            idBtmCad.setTranslateX(-3);
            idBtmCad.setTranslateY(3);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 8, -8);");
        });

        idBtmCad.setOnAction(event -> realizarCadastro());

    }

    private void configurarClickNaLogo() {

        if (logoCad != null) {

            logoCad.setCursor(javafx.scene.Cursor.HAND);

            logoCad.setOnMouseClicked(event -> voltarParaLogin());

        }

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

    private void validaEmTempoReal() {

        idNomeCad.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
            if (!temFocoAgora) {
                mostrarErro(Validacoes.validaNome(idNomeCad.getText()));
            }
        });

        idCpfCad.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
            if (!temFocoAgora) {
                mostrarErro(Validacoes.validaCpf(idCpfCad.getText()));
            }
        });

        idTelefoneCad.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
            if (!temFocoAgora) {
                mostrarErro(Validacoes.validaTelefone(idTelefoneCad.getText()));
            }
        });

        idEmailCad.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
            if (!temFocoAgora) {
                mostrarErro(Validacoes.validaEmail(idEmailCad.getText()));
            }
        });

        idDataCad.valueProperty().addListener((obs, valorAntigo, valorNovo) -> {
            if (valorNovo != null) {
                mostrarErro(Validacoes.validaData(valorNovo));
            }
        });

        idConfirmCad.textProperty().addListener((obs, valorAntigo, valorNovo) -> {
            if (!valorNovo.isEmpty()) {
                String erro = Validacoes.validaSenha(idSenhaCad.getText(), valorNovo);
                if (erro != null) {
                    mostrarErro(erro);
                } else {
                    msgErroLog.setTextFill(javafx.scene.paint.Color.GREEN);
                    msgErroLog.setText("Senhas iguais!");
                }
            }
        });
    }

    @FXML
    private void realizarCadastro() {

        msgErroLog.setText("");

        String nome = idNomeCad.getText();
        String cpf = idCpfCad.getText();
        String telefone = idTelefoneCad.getText();
        String email = idEmailCad.getText();
        String senha = idSenhaCad.getText();
        String confirm = idConfirmCad.getText();
        java.time.LocalDate dataNascimento = idDataCad.getValue();

        String erroNome = Validacoes.validaNome(nome);

        if (erroNome != null) { mostrarErro(erroNome); return; }

        String erroData = Validacoes.validaData(dataNascimento);

        if (erroData != null) { mostrarErro(erroData); return; }

        String erroCpf = Validacoes.validaCpf(cpf);

        if (erroCpf != null) { mostrarErro(erroCpf); return; }

        String erroTelefone = Validacoes.validaTelefone(telefone);

        if (erroTelefone != null) { mostrarErro(erroTelefone); return; }

        String erroEmail = Validacoes.validaEmail(email);

        if (erroEmail != null) { mostrarErro(erroEmail); return; }

        String erroSenha = Validacoes.validaSenha(senha, confirm);

        if (erroSenha != null) { mostrarErro(erroSenha); return; }

        Usuario usuario = new Usuario(nome, email, dataNascimento, telefone, cpf, senha);

        Repositorio.salvarUsuario(usuario);

        msgErroLog.setTextFill(javafx.scene.paint.Color.GREEN);
        msgErroLog.setText("Cadastro realizado com sucesso!");

        PauseTransition delay = new PauseTransition(Duration.seconds(1.5));

        delay.setOnFinished(event -> voltarParaLogin());

        delay.play();

    }

    private void mostrarErro(String erro) {

        if (erro != null) {

            msgErroLog.setTextFill(javafx.scene.paint.Color.RED);
            msgErroLog.setText(erro);


        } else {

            msgErroLog.setText("");

        }

    }

    private void voltarParaLogin() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/poo/registrationsystem/loginView.fxml"));

            Parent root = loader.load();

            Stage stage = (Stage) idBtmCad.getScene().getWindow();

            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

            System.out.println("Erro ao carregar a tela de Login. Verifique o caminho e o nome do arquivo FXML.");

        }
    }

}