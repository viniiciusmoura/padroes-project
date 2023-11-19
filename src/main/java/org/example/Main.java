package org.example;

import org.example.entity.BoletoBancoBrasil;
import org.example.entity.BoletoBradesco;
import org.example.entity.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        String caminho = "file:///home/vinicius/Documentos/IFTO/PP/stratgy/padroes-project/banco-brasil-1.csv";
        String caminhoBra ="file:///home/vinicius/Documentos/IFTO/PP/stratgy/padroes-project/bradesco-1.csv";

        System.out.println("----Banco do Brasil----");
        ProcessarBoletos processador = new ProcessarBoletos(new BoletoBancoBrasil());
        processador.processar(new URI(caminho));

        System.out.println("----Banco do Bradesco----");
        ProcessarBoletos processadorBra = new ProcessarBoletos(new BoletoBradesco());
        processadorBra.processar(new URI(caminhoBra));

    }
}