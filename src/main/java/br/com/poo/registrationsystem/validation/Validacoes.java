package br.com.poo.registrationsystem.validation;

import br.com.poo.registrationsystem.model.Usuario;

import java.util.List;

public class Validacoes {

    public static Usuario validarLogin(
            List<Usuario> usuarios,
            String email,
            String senha) {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)
                    && usuario.getSenha().equals(senha)) {

                return usuario;
            }
        }

        return null;
    }


}
