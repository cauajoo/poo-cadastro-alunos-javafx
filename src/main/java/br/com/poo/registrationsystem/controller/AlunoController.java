package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.repository.Repositorio;
import br.com.poo.registrationsystem.users.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.util.Optional;

public class AlunoController {

    @FXML
    private ListView<Aluno> idListaAlunos;

    @FXML
    private Button idBtmExcluir;

    @FXML
    private Label msgErroLog;

    @FXML
    public void initialize() {
        carregarLista();
    }

    private void carregarLista() {

        ObservableList<Aluno> alunos = FXCollections.observableArrayList(Repositorio.buscarTodoAluno());
        idListaAlunos.setItems(alunos);

        idListaAlunos.setCellFactory(param -> new ListCell<Aluno>() {

            @Override
            protected void updateItem(Aluno aluno, boolean vazio) {
                super.updateItem(aluno, vazio);

                if (vazio || aluno == null || aluno.getNome() == null) {
                    setText(null);

                } else {

                    setText(aluno.getNome() + " | Matrícula: " + aluno.getMatricula() + " | Turno: " + aluno.getTurno());

                }
            }
        });
    }

    @FXML
    private void excluirAluno(ActionEvent event) {

        Aluno alunoSelecionado = idListaAlunos.getSelectionModel().getSelectedItem();

        if (alunoSelecionado == null) {

            mostrarMensagem("Selecione um aluno na lista para excluir!", Color.WHITE);
            return;

        }

        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Confirmar Exclusão");
        confirmacao.setHeaderText(null);
        confirmacao.setContentText("Tem certeza que deseja excluir o aluno " + alunoSelecionado.getNome() + "?");

        Optional<ButtonType> resultado = confirmacao.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {

            Repositorio.removerAluno(alunoSelecionado);

            carregarLista();

            mostrarMensagem("Aluno excluído com sucesso!", Color.WHITE);

        } else {

            mostrarMensagem("", Color.BLACK);

        }
    }

    private void mostrarMensagem(String msg, Color cor) {

        if (msgErroLog != null) {
            msgErroLog.setTextFill(cor);
            msgErroLog.setText(msg);

        }
    }
}