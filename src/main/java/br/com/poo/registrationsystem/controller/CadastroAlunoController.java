package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.users.Aluno;
import br.com.poo.registrationsystem.validation.Validacoes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class CadastroAlunoController {

    @FXML
    private Button btnCadastrarAlu;

    @FXML
    private TextField idBairroAlu;

    @FXML
    private DatePicker idDataNasAlu;

    @FXML
    private TextField idDiscipllinasAlu;

    @FXML
    private TextField idMatriculaAlu;

    @FXML
    private TextField idNomeAlu;

    @FXML
    private TextField idNumCasAlu;

    @FXML
    private TextField idResponsavelAlu;

    @FXML
    private TextField idRuaAlu;

    @FXML
    private TextField idTurnoAlu;

//    private void validaEmTempoReal() {
//
//        idNomeAlu.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
//            if (!temFocoAgora) {
//                mostrarErro(Validacoes.validaNome(idNomeAlu.getText()));
//            }
//        });
//
//        idTurnoAlu.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
//            if (!temFocoAgora) {
//                idTurnoAlu(Validacoes.validarTurno(idTurnoAlu.getText()));
//            }
//        });
//
//        idTelefoneCad.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
//            if (!temFocoAgora) {
//                mostrarErro(Validacoes.validaTelefone(idTelefoneCad.getText()));
//            }
//        });
//
//        idEmailCad.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
//            if (!temFocoAgora) {
//                mostrarErro(Validacoes.validaEmail(idEmailCad.getText()));
//            }
//        });
//
//        idDataNasAlu.valueProperty().addListener((obs, valorAntigo, valorNovo) -> {
//            if (valorNovo != null) {
//                mostrarErro(Validacoes.validaData(valorNovo));
//            }
//        });
//
//        idConfirmCad.textProperty().addListener((obs, valorAntigo, valorNovo) -> {
//            if (!valorNovo.isEmpty()) {
//                String erro = Validacoes.validaSenha(idSenhaCad.getText(), valorNovo);
//                if (erro != null) {
//                    mostrarErro(erro);
//                } else {
//                    msgErroLog.setTextFill(javafx.scene.paint.Color.GREEN);
//                    msgErroLog.setText("Senhas iguais!");
//                }
//            }
//        });
//    }


//    @FXML
//    private void cadastrarAluno(ActionEvent event) {
//
//        String nome = idNomeAlu.getText();
//        java.time.LocalDate dataNascimento = idDataNasAlu.getValue();
//        String responsavel = idResponsavelAlu.getText();
//        String matricula = idMatriculaAlu.getText();
//        String turno = idTurnoAlu.getText();
//
//        String erroNome = Validacoes.validaNome(nome);
//
//        if (erroNome != null) { mostrarErro(erroNome); return; }
//
//
//
//
//        private void mostrarErro(String erro) {
//
//            if (erro != null) {
//
//                msgErroLog.setTextFill(javafx.scene.paint.Color.RED);
//                msgErroLog.setText(erro);
//
//            } else {
//
//                msgErroLog.setText("");
//
//            }
//
//        }
//    }

    private void limparCampos() {
        idNomeAlu.clear();
        idDataNasAlu.setValue(null);
        idBairroAlu.clear();
        idRuaAlu.clear();
        idNumCasAlu.clear();
        idMatriculaAlu.clear();
        idTurnoAlu.clear();
        idDiscipllinasAlu.clear();
        idResponsavelAlu.clear();
    }

}
