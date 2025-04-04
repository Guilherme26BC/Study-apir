package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Product;

import java.math.BigDecimal;

public class ProductRequestUpdate {
    private BigDecimal valor;

    public Product toModel(Product p){
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
