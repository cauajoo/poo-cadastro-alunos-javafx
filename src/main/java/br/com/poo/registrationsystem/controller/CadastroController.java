package br.com.poo.registrationsystem.controller;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class CadastroController {

    @FXML
    private ImageView forma_dois_cad;
    @FXML
    private ImageView forma_quatro_cad;
    @FXML
    private ImageView forma_tres_cad;
    @FXML
    private ImageView forma_um_cad;
    @FXML
    private PasswordField id_confirmS_cad;
    @FXML
    private TextField id_cpf_cad;
    @FXML
    private DatePicker id_data_cad;
    @FXML
    private TextField id_email_cad;
    @FXML
    private TextField id_nome_cad;
    @FXML
    private PasswordField id_senha_cad;
    @FXML
    private TextField id_telefone_cad;
    @FXML
    private ImageView logo_cad;
    @FXML
    private Label mensagem_erro;
    @FXML
    private Button id_btm_cad;


    public void initialize() {

        animarFlutuacao(forma_um_cad, -15, 3000);
        animarFlutuacao(forma_dois_cad, 20, 2500);
        animarFlutuacao(forma_tres_cad, -10, 3000);
        animarFlutuacao(forma_quatro_cad, 10, 2500);

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