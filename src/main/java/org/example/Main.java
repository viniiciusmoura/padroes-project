package org.example;

import org.example.entity.Produto;
import org.example.entity.ProdutoBuilder;

import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Produto p = new ProdutoBuilder()
                .titulo("teste")
                .preco(10.5)
                .dataCadastro(LocalDate
                        .now())
               .dataUltimaAtualizacao(LocalDate.now().plusDays(2))
               .createProduto();
        System.out.println("==>"+p);
    }
}