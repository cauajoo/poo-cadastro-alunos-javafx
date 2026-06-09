package br.com.poo.registrationsystem.repository;

import br.com.poo.registrationsystem.users.Aluno;
import br.com.poo.registrationsystem.users.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repositorio{

    private static List<Usuario> usuarios = new ArrayList<>();

    private static List<Aluno> alunos = new ArrayList<>();

    static {
        usuarios.add(new Usuario(

                "Cauã João",
                "caua@gmail.com",
                LocalDate.of(2005, 5, 10),
                "83999999999",
                "11111111111",
                "12345678"

        ));
    }

    static {

        Aluno caua = new Aluno(
                "Cauã João",
                LocalDate.of(2005, 5, 20),
                "Responsável do Cauã",
                "202617896",
                "Manhã"
        );

        Aluno daniel = new Aluno(
                "Daniel",
                LocalDate.of(2026, 6, 1),
                "Maria",
                "2026753781",
                "Manhã"
        );

        alunos.add(caua);
        alunos.add(daniel);
    }

    public static void salvarUsuario(Usuario usuario){

        usuarios.add(usuario);

    }

    public static void salvarAlunos(Aluno aluno){


        alunos.add(aluno);

    }

    public static List<Aluno> buscarTodoAluno() {

        return alunos;

    }

    public static List<Usuario> buscarTodoUsuario() {

        return usuarios;

    }

    public static String validaNota(String notaTexto, String nomeDaUnidade) {

        if (notaTexto == null || notaTexto.trim().isEmpty()) {

            return "A nota da " + nomeDaUnidade + " não pode ser vazia!";

        }

        try {

            double nota = Double.parseDouble(notaTexto.trim().replace(",", "."));

            if (nota < 0 || nota > 10) {

                return "A nota da " + nomeDaUnidade + " deve estar entre 0 e 10!";

            }

            return null;

        } catch (NumberFormatException e) {

            return "A nota da " + nomeDaUnidade + " deve ser um número válido!";
        }

    }

    public static void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }



}
