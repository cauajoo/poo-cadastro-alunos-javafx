package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.model.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

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

    private static final List<Aluno> alunos = new ArrayList<>();

    @FXML
    private void cadastrarAluno(ActionEvent event) {

        Aluno aluno = new Aluno();

        aluno.setNome(idNomeAlu.getText());
        aluno.setDataDeNascimento(String.valueOf(idDataNasAlu.getValue()));
        aluno.setResponsaveis(idResponsavelAlu.getText());
        aluno.setBairro(idBairroAlu.getText());
        aluno.setRua(idRuaAlu.getText());
        aluno.setNumeroCasa(Integer.parseInt(idNumCasAlu.getText()));
        aluno.setMatricula(Integer.parseInt(idMatriculaAlu.getText()));
        aluno.setTurno(idTurnoAlu.getText());
        aluno.setDisciplinas(idDiscipllinasAlu.getText());

        alunos.add(aluno);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro");
        alert.setHeaderText("Aluno cadastrado com sucesso!");
        alert.setContentText("Aluno: " + aluno.getNome());
        alert.showAndWait();

        limparCampos();
    }

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
