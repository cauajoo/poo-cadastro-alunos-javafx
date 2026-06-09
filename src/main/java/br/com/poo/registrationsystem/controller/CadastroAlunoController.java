package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.repository.Repositorio;
import br.com.poo.registrationsystem.users.Aluno;
import br.com.poo.registrationsystem.validation.Validacoes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.util.Random;

public class CadastroAlunoController {

    @FXML
    private TextField idNomeAlu;

    @FXML
    private TextField idResponsavelAlu;

    @FXML
    private DatePicker idDataNasAlu;

    @FXML
    private TextField idTurnoAlu;

    @FXML
    private TextField idMatriculaAlu;

    @FXML
    private Button btmGerarMatri;

    @FXML
    private Button btnCadastrarAlu;

    @FXML
    private Label msgErroLog;

    @FXML
    public void initialize() {
        validaEmTempoReal();
    }

    private void validaEmTempoReal() {

        if (idNomeAlu != null) {

            idNomeAlu.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
                if (!temFocoAgora) mostrarErro(Validacoes.validaNome(idNomeAlu.getText()));
            });

        }

        if (idResponsavelAlu != null) {

            idResponsavelAlu.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
                if (!temFocoAgora) mostrarErro(Validacoes.validaCampoVazio(idResponsavelAlu.getText(), "Responsável"));
            });

        }

        if (idTurnoAlu != null) {

            idTurnoAlu.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
                if (!temFocoAgora) mostrarErro(Validacoes.validaTurno(idTurnoAlu.getText()));
            });

        }

        if (idMatriculaAlu != null) {

            idMatriculaAlu.focusedProperty().addListener((obs, tinhaFoco, temFocoAgora) -> {
                if (!temFocoAgora) mostrarErro(Validacoes.validaMatriculaExistente(Repositorio.buscarTodoAluno(), idMatriculaAlu.getText()));
            });

        }
    }

    @FXML
    private void gerarMatricula(ActionEvent event) {

        Random random = new Random();
        String anoAtual = String.valueOf(LocalDate.now().getYear());
        String matriculaGerada;

        do {

            int numero = 100000 + random.nextInt(900000);
            matriculaGerada = anoAtual + numero;

        } while (Validacoes.existeMatricula(Repositorio.buscarTodoAluno(), matriculaGerada));

        idMatriculaAlu.setText(matriculaGerada);
        mostrarErro(null);

    }

    @FXML
    private void cadastrarAluno(ActionEvent event) {

        String erroNome = Validacoes.validaNome(idNomeAlu.getText());

        String erroResp = Validacoes.validaCampoVazio(idResponsavelAlu.getText(), "Responsável");

        String erroTurno = Validacoes.validaTurno(idTurnoAlu.getText());

        String erroMatricula = Validacoes.validaMatriculaExistente(Repositorio.buscarTodoAluno(), idMatriculaAlu.getText());

        if (idDataNasAlu.getValue() == null) {

            mostrarErro("A Data de Nascimento é obrigatória!");
            return;

        }

        if (erroNome != null) { mostrarErro(erroNome); return; }
        if (erroResp != null) { mostrarErro(erroResp); return; }
        if (erroTurno != null) { mostrarErro(erroTurno); return; }
        if (erroMatricula != null) { mostrarErro(erroMatricula); return; }

        Aluno aluno = new Aluno(
                idNomeAlu.getText(),
                idDataNasAlu.getValue(),
                idResponsavelAlu.getText(),
                idMatriculaAlu.getText(),
                idTurnoAlu.getText()
        );

        Repositorio.salvarAlunos(aluno);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro");
        alert.setHeaderText(null);
        alert.setContentText("Aluno " + aluno.getNome() + " cadastrado com sucesso!");
        alert.showAndWait();

        limparCampos();
        mostrarErro(null);
    }

    private void mostrarErro(String erro) {
        if (msgErroLog != null) {
            if (erro != null) {
                msgErroLog.setTextFill(Color.RED);
                msgErroLog.setText(erro);
            } else {
                msgErroLog.setText("");
            }
        }
    }

    private void limparCampos() {
        if (idNomeAlu != null) idNomeAlu.clear();
        if (idDataNasAlu != null) idDataNasAlu.setValue(null);
        if (idResponsavelAlu != null) idResponsavelAlu.clear();
        if (idMatriculaAlu != null) idMatriculaAlu.clear();
        if (idTurnoAlu != null) idTurnoAlu.clear();
    }
}