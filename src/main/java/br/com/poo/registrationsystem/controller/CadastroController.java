package br.com.poo.registrationsystem.controller;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.effect.DropShadow;

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
    private Label mensagem_erro;

    public void initialize() {

        animarFlutuacao(formaUmCad, -15, 3000);
        animarFlutuacao(formaDoisCad, 20, 2500);
        animarFlutuacao(formaTresCad, -10, 3000);
        animarFlutuacao(formaQuatroCad, 10, 2500);

        animarBotao();

    }

    private void animarBotao() {
        if (idBtmCad == null) return;

        String visualBase = "-fx-background-color: #FF5E4D; -fx-background-radius: 8px; " +
                "-fx-background-insets: 1px; -fx-border-color: black; " +
                "-fx-border-width: 3px; -fx-border-radius: 8px; " +
                "-fx-font-weight: bold; -fx-text-fill: white; ";

        // 1. Estado Normal (Sombra no topo-direito: 5, -5)
        idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 5, -5);");

        // 2. Mouse Entrou: Levanta o botão (Vem para a Esquerda e para Baixo)
        idBtmCad.setOnMouseEntered(e -> {
            idBtmCad.setCursor(javafx.scene.Cursor.HAND);
            idBtmCad.setTranslateX(-3);
            idBtmCad.setTranslateY(3);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 8, -8);");
        });

        // 3. Mouse Saiu: Volta ao normal
        idBtmCad.setOnMouseExited(e -> {
            idBtmCad.setTranslateX(0);
            idBtmCad.setTranslateY(0);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 5, -5);");
        });

        // 4. Clicou: Afunda o botão (Vai para a Direita e para Cima, de encontro à sombra)
        idBtmCad.setOnMousePressed(e -> {
            idBtmCad.setTranslateX(3);
            idBtmCad.setTranslateY(-3);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 2, -2);");
        });

        // 5. Soltou o clique: Volta para a posição levantada
        idBtmCad.setOnMouseReleased(e -> {
            idBtmCad.setTranslateX(-3);
            idBtmCad.setTranslateY(3);
            idBtmCad.setStyle(visualBase + "-fx-effect: dropshadow(one-pass-box, black, 0, 0, 8, -8);");
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