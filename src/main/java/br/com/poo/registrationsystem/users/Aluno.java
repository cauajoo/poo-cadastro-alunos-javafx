package br.com.poo.registrationsystem.users;

import java.time.LocalDate;

public class Aluno {

    private String nome;
    private LocalDate dataDeNascimento;
    private String responsaveis;
    private String bairro;
    private String rua;
    private String numeroCasa;
    private String turno;
    private String disciplinas;
    private String matricula;

    public Aluno(String nome, LocalDate dataDeNascimento, String responsaveis, String bairro, String rua, String numeroCasa, String matricula, String turno, String disciplinas) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.responsaveis = responsaveis;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.matricula = matricula;
        this.turno = turno;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getResponsaveis() {
        return responsaveis;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public String getTurno() {
        return turno;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public String getMatricula() {
        return matricula;
    }
}