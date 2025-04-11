package com.github.acnaweb.study_apir.dto.produto;

import com.github.acnaweb.study_apir.model.Produtos;

import java.math.BigDecimal;

public class ProdutoRequestUpdate {
    private BigDecimal valor;

    public Produtos toModel(Produtos p){
        p.setValor(this.getValor());
        return p;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
