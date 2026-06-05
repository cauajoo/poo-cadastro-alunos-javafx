package br.com.poo.registrationsystem.dateBank;

import br.com.poo.registrationsystem.model.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorArquivos {

    private static final String nomeArquivo = "usuarios.txt";

    public static boolean salvarUsuario(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {

            String linha = usuario.getNome() + ";" +
                    usuario.getEmail() + ";" +
                    usuario.getDataNascimento() + ";" +
                    usuario.getTelefone() + ";" +
                    usuario.getCpf() + ";" +
                    usuario.getSenha();

            writer.write(linha);
            writer.newLine();
            return true;

        } catch (IOException e){
            System.out.println("Erro ao salvar usuário: "+ e.getMessage());
            return false;
        }
    }


}
