package br.com.poo.registrationsystem.repository;

import br.com.poo.registrationsystem.users.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Repositorio{

    private static List<Usuario> usuarios = new ArrayList<>();

    public static void salvarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public static List<Usuario> buscarTodoUsuario() {
        return usuarios;
    }

}
