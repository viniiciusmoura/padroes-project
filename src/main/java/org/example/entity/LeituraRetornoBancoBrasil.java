package org.example.entity;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class LeituraRetornoBancoBrasil implements LeituraRetorno{
    @Override
    public List<Boleto> lerArquivo(URI caminhoArquivo) {
        var boletos = new ArrayList<Boleto>();
        try {
            var listLine = Files.readAllLines(Paths.get(caminhoArquivo));
            var formt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (var linha : listLine) {
                var vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2],formt));
                boleto.setDataEmissao(LocalDate.parse(vetor[3],formt).atTime(0,0));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setAgencia(vetor[7]);
                boletos.add(boleto);
            }
            System.out.println("-------Banco do Brasil ------------");
            boletos.forEach(System.out::println);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return boletos;
//        throw  new UnsupportedOperationException("método incompleto");
    }
}
