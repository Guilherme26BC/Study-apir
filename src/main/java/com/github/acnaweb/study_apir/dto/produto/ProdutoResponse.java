package com.github.acnaweb.study_apir.dto.produto;

import com.github.acnaweb.study_apir.model.Produtos;

import java.math.BigDecimal;

public class ProdutoResponse {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public ProdutoResponse toDto(Produtos produtos){
        this.setId(produtos.getId());
        this.setNome(produtos.getNome());
        this.setValor(produtos.getValor());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
