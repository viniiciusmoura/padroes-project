package org.example.entity;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ProcessarBoletos {

    private static DateTimeFormatter FORMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static DateTimeFormatter FORMT_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Function<URI, List<Boleto>> leituraRetornoN;

    public ProcessarBoletos(Function<URI, List<Boleto>> leituraRetornoN)
    {
        this.leituraRetornoN = leituraRetornoN;
    }

    public void processar(URI file)
    {
        List<Boleto> boletos = leituraRetornoN.apply(file);
        for (Boleto boleto : boletos)
        {
            System.out.println(boleto);
        }
    }

    public static List<Boleto> lerBancoBrasil(URI file)
    {
        try {
            var listLine = Files.readAllLines(Paths.get(file));
            List<Boleto> boletos = new ArrayList<>();

            for (var linha : listLine) {
                var vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);

                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMT));
                boleto.setDataEmissao(LocalDate.parse(vetor[3], FORMT).atTime(0,0));

                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setAgencia(vetor[7]);
                boletos.add(boleto);
            }
            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static List<Boleto> lerBradesco(URI file)
    {
        try {
            var listLine = Files.readAllLines(Paths.get(file));
            List<Boleto> boletos = new ArrayList<>();

            for (var linha:listLine){
                var vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMT));
                boleto.setDataEmissao(LocalDateTime.parse(vetor[5], FORMT_DATA));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}