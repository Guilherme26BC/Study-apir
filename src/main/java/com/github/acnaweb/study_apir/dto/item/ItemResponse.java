package com.github.acnaweb.study_apir.dto.item;

import com.github.acnaweb.study_apir.model.Itens;

import java.math.BigDecimal;

public class ItemResponse {
    private Long id;
    private String produto_nome;
    private BigDecimal valor;
    private BigDecimal quantidade;

    public ItemResponse toDto(Itens item) {
        this.setId(item.getItem_id());
        this.setValor(item.getValor());
        this.setQuantidade(item.getQuantidade());
        this.setProduto_nome(item.getProduto().getNome());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto_nome() {
        return produto_nome;
    }

    public void setProduto_nome(String produto_nome) {
        this.produto_nome = produto_nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
}
