package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Produtos;

import java.math.BigDecimal;

public class ProdutoRequestCreate {
    private String nome;

    public Produtos toModel(){
        BigDecimal VALOR_PADRAO = new BigDecimal(500);
        Produtos p = new Produtos();
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

