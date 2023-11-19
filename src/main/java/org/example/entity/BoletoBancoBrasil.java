package org.example.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoBancoBrasil implements LeituraRetorno{

    private static DateTimeFormatter FORMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Boleto processarLinhaArquivo(String[] vetor) {
        var boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);

        boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMT));
        boleto.setDataEmissao(LocalDate.parse(vetor[3], FORMT).atTime(0,0));

        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));

        return boleto;
    }
}