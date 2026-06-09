package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.repository.Repositorio;
import br.com.poo.registrationsystem.users.Aluno;
import br.com.poo.registrationsystem.users.Notas;
import br.com.poo.registrationsystem.validation.Validacoes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class CadastroNotasController {

    @FXML
    private ListView<Aluno> idListaAlunos;

    @FXML
    private TextField idNota1;

    @FXML
    private TextField idNota2;

    @FXML
    private TextField idNota3;

    @FXML
    private Button btnSalvarNotas;

    @FXML
    private Label msgErroLog;

    @FXML
    public void initialize() {

        carregarListaDeAlunos();
        configurarCliqueNaLista();

    }

    private void carregarListaDeAlunos() {

        ObservableList<Aluno> alunos = FXCollections.observableArrayList(Repositorio.buscarTodoAluno());
        idListaAlunos.setItems(alunos);

        idListaAlunos.setCellFactory(param -> new ListCell<Aluno>() {

            @Override
            protected void updateItem(Aluno aluno, boolean vazio) {
                super.updateItem(aluno, vazio);

                if (vazio || aluno == null || aluno.getNome() == null) {

                    setText(null);

                } else {

                    setText(aluno.getNome() + " (Matrícula: " + aluno.getMatricula() + ")");

                }
            }
        });
    }

    private void configurarCliqueNaLista() {

        idListaAlunos.getSelectionModel().selectedItemProperty().addListener((obs, alunoAntigo, alunoNovo) -> {

            if (alunoNovo != null) {

                Notas notasDoAluno = alunoNovo.getNotas();

                if (notasDoAluno != null) {

                    idNota1.setText(String.valueOf(notasDoAluno.getNota1()));
                    idNota2.setText(String.valueOf(notasDoAluno.getNota2()));
                    idNota3.setText(String.valueOf(notasDoAluno.getNota3()));

                }

                mostrarErro(null);

            }
        });
    }

    @FXML
    private void salvarNotas(ActionEvent event) {

        Aluno alunoSelecionado = idListaAlunos.getSelectionModel().getSelectedItem();

        if (alunoSelecionado == null) {

            mostrarErro("Selecione um aluno na lista primeiro!");
            return;

        }

        String erroN1 = Validacoes.validaNota(idNota1.getText(), "Unidade 1");
        String erroN2 = Validacoes.validaNota(idNota2.getText(), "Unidade 2");
        String erroN3 = Validacoes.validaNota(idNota3.getText(), "Unidade 3");

        if (erroN1 != null) { mostrarErro(erroN1); return; }
        if (erroN2 != null) { mostrarErro(erroN2); return; }
        if (erroN3 != null) { mostrarErro(erroN3); return; }

        double n1 = Double.parseDouble(idNota1.getText().trim().replace(",", "."));
        double n2 = Double.parseDouble(idNota2.getText().trim().replace(",", "."));
        double n3 = Double.parseDouble(idNota3.getText().trim().replace(",", "."));

        alunoSelecionado.setNotas(new Notas(n1, n2, n3));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText("Notas do aluno " + alunoSelecionado.getNome() + " salvas com sucesso!");
        alert.showAndWait();

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
}