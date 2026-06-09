package br.com.poo.registrationsystem.repository;

import br.com.poo.registrationsystem.users.Aluno;
import br.com.poo.registrationsystem.users.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Repositorio{

    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Aluno> alunos = new ArrayList<>();

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



}
