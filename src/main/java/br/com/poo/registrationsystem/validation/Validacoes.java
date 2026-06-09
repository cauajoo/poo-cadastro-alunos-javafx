package br.com.poo.registrationsystem.validation;

import br.com.poo.registrationsystem.users.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Validacoes {

    public static Usuario validarLogin(List<Usuario> usuarios, String email, String senha) {

        if (usuarios == null || email == null || senha == null) {
            return null;
        }

        return usuarios.stream()
                .filter(u -> Objects.equals(email, u.getEmail()) && Objects.equals(senha, u.getSenha()))
                .findFirst()
                .orElse(null);
    }

    public static String validaNome(String nome){

        if(nome == null || nome.trim().isEmpty()){

            return "O nome não pode ser vazio!";

        }

        if(nome.trim().length() < 3){

            return "O nome deve ter pelo menos 3 letras!";

        }

        return null;

    }

    public static String validaCpf(String cpf){

        if(cpf == null || cpf.trim().isEmpty()){

            return "O CPF não pode ser vazio!";

        }

        String cpfNumeros = cpf.replaceAll("[^0-9]", "");

        if(cpfNumeros.length() != 11){

            return "O CPF deve conter exatamente 11 números!";

        }

        return null;

    }

    public static String validaTelefone(String telefone){

        if(telefone == null || telefone.trim().isEmpty()){

            return "O Telefone não pode ser vazio!";

        }

        String telNumeros = telefone.replaceAll("[^0-9]", "");

        if(telNumeros.length() < 10 || telNumeros.length() > 11){

            return "Digite um telefone válido com DDD";

        }

        return null;

    }

    public static String validaData(LocalDate data){

        if(data == null){

            return "Selecione uma data de nascimento!";

        }

        if(data.isAfter(LocalDate.now())){

            return "A data de nascimento deve ser retroativa ao dia de hoje!";

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

            return "A senha não pode estar vazia.";

        }

        if (senha.length() < 8) {

            return "A senha deve ter pelo menos 8 caracteres.";

        }

        if (!senha.equals(confirmacao)) {

            return "As senhas não coincidem.";

        }

        return null;

    }

    private static boolean isEmailValido(String email) {

        String expressaoRegular = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        return email.matches(expressaoRegular);
    }

}
