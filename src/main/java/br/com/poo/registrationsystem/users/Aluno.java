package br.com.poo.registrationsystem.users;

public class Aluno {

    private String nome;
    private String dataDeNascimento;
    private String responsaveis;
    private String bairro;
    private String rua;
    private int numeroCasa;
    private String turno;
    private String disciplinas;
    private int matricula;

    public Aluno(String nome, String dataDeNascimento, String responsaveis, String bairro, String rua, int numeroCasa, String turno, String disciplinas, int matricula) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.responsaveis = responsaveis;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.turno = turno;
        this.disciplinas = disciplinas;
        this.matricula = matricula;
    }

    public Aluno() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(String responsaveis) {
        this.responsaveis = responsaveis;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}