package br.com.poo.registrationsystem.users;

import java.time.LocalDate;

public class Aluno {

    private String nome;
    private LocalDate dataDeNascimento;
    private String responsaveis;
    private String turno;
    private String matricula;
    private Notas notas;

    public Aluno(String nome, LocalDate dataDeNascimento, String responsaveis, String matricula, String turno) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.responsaveis = responsaveis;
        this.matricula = matricula;
        this.turno = turno;
        this.notas = new Notas(0.0, 0.0, 0.0);
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

    public String getTurno() {
        return turno;
    }

    public String getMatricula() {
        return matricula;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }
}