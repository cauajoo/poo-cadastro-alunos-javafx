package br.com.poo.registrationsystem.model;

public class EnderecoAluno {

    private String bairro;
    private String rua;
    private int numeroCasa;

    public EnderecoAluno(String bairro, String rua, int numeroCasa) {
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
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
}
