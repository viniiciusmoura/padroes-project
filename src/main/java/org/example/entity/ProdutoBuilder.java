package org.example.entity;

import java.time.LocalDate;

public class ProdutoBuilder {
    private String titulo;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private String categoria;
    private Long id = Long.parseLong("0");
    private String descricao = "";
    private String marca = "";
    private String modelo = "";
    private int estoque = 0;
    private String uriFoto = "";
    private String vendedor = "";
    private double peso = 0;
    private double altura = 0;
    private double largura = 0;
    private double profundidado = 0;

    public ProdutoBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ProdutoBuilder preco(double preco) {
        this.preco = preco;
        return this;
    }

    public ProdutoBuilder dataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public ProdutoBuilder dataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        return this;
    }

    public ProdutoBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProdutoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProdutoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProdutoBuilder marca(String marca) {
        this.marca = marca;
        return this;
    }

    public ProdutoBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public ProdutoBuilder estoque(int estoque) {
        this.estoque = estoque;
        return this;
    }

    public ProdutoBuilder uriFoto(String uriFoto) {
        this.uriFoto = uriFoto;
        return this;
    }

    public ProdutoBuilder vendedor(String vendedor) {
        this.vendedor = vendedor;
        return this;
    }

    public ProdutoBuilder peso(double peso) {
        this.peso = peso;
        return this;
    }

    public ProdutoBuilder altura(double altura) {
        this.altura = altura;
        return this;
    }

    public ProdutoBuilder largura(double largura) {
        this.largura = largura;
        return this;
    }

    public ProdutoBuilder profundidado(double profundidado) {
        this.profundidado = profundidado;
        return this;
    }

    public Produto createProduto() {
        return new Produto(titulo, preco, dataCadastro, dataUltimaAtualizacao, categoria);
    }
}