package br.com.poo.registrationsystem.controller;

import br.com.poo.registrationsystem.repository.Repositorio;
import br.com.poo.registrationsystem.users.Aluno;
import br.com.poo.registrationsystem.users.Notas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class MediaController {

    @FXML
    private ListView<Aluno> idListaMedias;

    @FXML
    public void initialize() {

        carregarListaDeMedias();

    }

    private void carregarListaDeMedias() {

        ObservableList<Aluno> alunos = FXCollections.observableArrayList(Repositorio.buscarTodoAluno());
        idListaMedias.setItems(alunos);

        idListaMedias.setCellFactory(param -> new ListCell<Aluno>() {

            @Override
            protected void updateItem(Aluno aluno, boolean vazio) {

                super.updateItem(aluno, vazio);

                if (vazio || aluno == null || aluno.getNome() == null) {

                    setText(null);

                } else {

                    Notas notas = aluno.getNotas();
                    double media = 0.0;

                    if (notas != null) {

                        media = (notas.getNota1() + notas.getNota2() + notas.getNota3()) / 3.0;

                    }

                    String status;

                    if (media >= 7.0) {

                        status = "✅ APROVADO";

                    } else if (media >= 4.0) {

                        status = "⚠️ FINAL";

                    } else {

                        status = "❌ REPROVADO";

                    }

                    String textoFinal = String.format("Aluno: %s  |  Média Final: %.1f  |  %s",
                            aluno.getNome(), media, status);

                    setText(textoFinal);
                }
            }
        });
    }
}