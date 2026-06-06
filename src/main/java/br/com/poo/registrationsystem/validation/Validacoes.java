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

    public static String validaEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "O campo de email não pode estar vazio.";
        }

        if (!isEmailValido(email)) {
            return "Introduza um endereço de email válido.";
        }

        return null;
    }

    public static String validaSenha(String senha, String confirmacao) {
        if (senha == null || senha.trim().isEmpty()) {
            return "Erro: A senha não pode estar vazia.";
        }
        if (senha.length() < 8) {
            return "Erro: A senha deve ter pelo menos 8 caracteres.";
        }
        if (!senha.equals(confirmacao)) {
            return "Erro: As senhas não coincidem.";
        }
        return null;
    }

    private static boolean isEmailValido(String email) {
        String expressaoRegular = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        return email.matches(expressaoRegular);
    }
}
