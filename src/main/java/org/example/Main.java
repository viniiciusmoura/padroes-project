package org.example;

import org.example.entity.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        String caminho = "file:///home/vinicius/Documentos/IFTO/PP/stratgy/padroes-project/banco-brasil-1.csv";
        String caminhoBra ="file:///home/vinicius/Documentos/IFTO/PP/stratgy/padroes-project/bradesco-1.csv";

        System.out.println("----Banco do Brasil----");
        ProcessarBoletos processador = new ProcessarBoletos(ProcessarBoletos::lerBancoBrasil);
        processador.processar(new URI(caminho));

        System.out.println("\n----Banco do Bradesco----");
        ProcessarBoletos processadorBras = new ProcessarBoletos(ProcessarBoletos::lerBradesco);
        processadorBras.processar(new URI(caminhoBra));

    }
}