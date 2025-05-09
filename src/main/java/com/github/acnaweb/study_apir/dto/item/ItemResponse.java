package com.github.acnaweb.study_apir.dto.item;

import com.github.acnaweb.study_apir.model.Itens;

import java.math.BigDecimal;

public class ItemResponse {
    private Long id;
    private String produto_nome;
    private BigDecimal valor;
    private BigDecimal quantidade;

    public ItemResponse toDto(Itens i){
        this.setId(i.getItem_id());
        this.setQuantidade(i.getQuantidade());
        this.setValor(i.getValor());
        this.setProduto_nome(i.getProduto().getNome());

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
