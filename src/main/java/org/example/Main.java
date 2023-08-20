package org.example;

import org.example.entity.LeituraRetorno;
import org.example.entity.LeituraRetornoBancoBrasil;
import org.example.entity.LeituraRetornoBradesco;
import org.example.entity.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        System.out.println("Hello world!");
        var leituraRetorno = new LeituraRetornoBancoBrasil();
        var processador = new ProcessarBoletos(leituraRetorno);
        String caminho = "file:///home/vinicius/Documentos/IFTO/6_SEMESTRE/PP/Aula02/getBoleto/banco-brasil-1.csv";
        processador.processar(new URI(caminho));


        //Bradesco
        var leituraRetornoBra = new LeituraRetornoBradesco();
        var processadorBradesco = new ProcessarBoletos(leituraRetornoBra);
        String caminhoBra ="file:///home/vinicius/Documentos/IFTO/6_SEMESTRE/PP/Aula02/getBoleto/bradesco-1.csv";
        processadorBradesco.processar(new URI(caminhoBra));
    }
}