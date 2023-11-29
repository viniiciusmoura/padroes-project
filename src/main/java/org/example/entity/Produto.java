package org.example.entity;

import java.time.LocalDate;


public class Produto
{
    private Long id;
    private String titulo;
    private String descricao;
    private String marca;
    private String modelo;
    private int estoque;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private String uriFoto;
    private String categoria;
    private String vendedor;
    private double peso;
    private double altura;
    private double largura;
    private  double profundidado;

     Produto(String titulo, double preco, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao, String categoria) {
        this.titulo = titulo;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.categoria = categoria;
    }

    private Produto(Long id, String titulo, String descricao, String marca, String modelo, int estoque, double preco, LocalDate dataCadastro, LocalDate dataUltimaAtualizacao, String uriFoto, String categoria, String vendedor, double peso, double altura, double largura, double profundidado) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.estoque = estoque;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.uriFoto = uriFoto;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.profundidado = profundidado;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", estoque=" + estoque +
                ", preco=" + preco +
                ", dataCadastro=" + dataCadastro +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", uriFoto='" + uriFoto + '\'' +
                ", categoria='" + categoria + '\'' +
                ", vendedor='" + vendedor + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", largura=" + largura +
                ", profundidado=" + profundidado +
                '}';
    }
}
