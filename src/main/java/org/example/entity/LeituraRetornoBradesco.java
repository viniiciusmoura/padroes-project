package org.example.entity;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno{
    @Override
    public List<Boleto> lerArquivo(URI caminhoArquivo) {
        var boletos = new ArrayList<>();

        try {
            var listLine= Files.readAllLines(Paths.get(caminhoArquivo));

            var formt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            var formtVencimento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (var linha:listLine){
                var vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4],formtVencimento));
                boleto.setDataEmissao(LocalDateTime.parse(vetor[5],formt));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));
                boletos.add(boleto);
            }
            System.out.println("------- Banco do Bradesco ---------");
            boletos.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}
