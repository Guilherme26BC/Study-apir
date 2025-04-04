package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Product;

import java.math.BigDecimal;

public class ProductRequestCreate {
    private String nome;

    public Product toModel(){
        BigDecimal VALOR_PADRAO = new BigDecimal(500);
        Product p = new Product();
        p.setNome(this.getNome());
        p.setValor(VALOR_PADRAO);
        return p;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}

