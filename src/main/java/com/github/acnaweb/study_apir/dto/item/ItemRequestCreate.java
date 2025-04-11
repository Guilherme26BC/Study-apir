package com.github.acnaweb.study_apir.dto.item;

import com.github.acnaweb.study_apir.model.Itens;

import java.math.BigDecimal;
import java.util.List;

public class ItemRequestCreate {
    private Long produto_id;
    private BigDecimal quantidade;
    private BigDecimal valor;

    public Itens toModel(){
        return null;
    }

    public Long getProduto() {
        return produto_id;
    }

    public void setProduto(Long produto) {
        this.produto_id = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
