package org.example.entity;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ProcessarBoletos {

    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetornoN)
    {
        this.leituraRetorno = leituraRetornoN;
    }

    public final void processar(URI file)
    {
        List<Boleto> boletos = new ArrayList<>();
        try {
            var listaLinhas = Files.readAllLines(Paths.get(file));
            for (String linha : listaLinhas) {
                String[] vetor = linha.split(";");
                final var boleto = leituraRetorno.processarLinhaArquivo(vetor);
                boletos.add(boleto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (var boleto : boletos) {
            System.out.println(boleto);
        }

    }
}