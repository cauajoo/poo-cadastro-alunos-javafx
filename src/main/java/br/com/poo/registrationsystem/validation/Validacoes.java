package br.com.poo.registrationsystem.validation;

import br.com.poo.registrationsystem.users.Aluno;
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

    public static boolean existeMatricula(List<Aluno> alunos, String matricula) {

        if (alunos == null || matricula == null) return false;

        return alunos.stream()
                .anyMatch(a -> matricula.equals(a.getMatricula()));

    }

    public static String validaMatriculaExistente(List<Aluno> alunos, String matricula) {

        if (matricula == null || matricula.trim().isEmpty()) {

            return "A matrícula não pode ser vazia!";

        }

        if (existeMatricula(alunos, matricula)) {

            return "Esta matrícula já está em uso!";

        }

        return null;

    }

    public static String validaCampoVazio(String texto, String nomeDoCampo) {

        if (texto == null || texto.trim().isEmpty()) {

            return "O campo " + nomeDoCampo + " é obrigatório!";

        }

        return null;

    }

    public static String validaTurno(String turno) {

        if (turno == null || turno.trim().isEmpty()) {

            return "O Turno é obrigatório!";

        }

        String turnoFormatado = turno.trim().toLowerCase();

        if (!turnoFormatado.equals("manhã") && !turnoFormatado.equals("manha")
                && !turnoFormatado.equals("tarde") && !turnoFormatado.equals("noite")) {

            return "Turno inválido! Digite Manhã, Tarde ou Noite.";

        }
        return null;
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
}
