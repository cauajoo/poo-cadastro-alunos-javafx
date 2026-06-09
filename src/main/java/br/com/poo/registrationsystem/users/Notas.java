package br.com.poo.registrationsystem.users;
import br.com.poo.registrationsystem.controller.CadastroAlunoController;
import br.com.poo.registrationsystem.controller.CadastroController;

import java.util.ArrayList;
import java.util.List;

public class Notas {

    private double nota1;
    private double nota2;
    private double nota3;

    public Notas(double nota1, double nota2, double nota3) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }
}

