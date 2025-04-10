package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Pedido;

public class PedidoRequestCreate {
    private String status;

    public Pedido toModel(){
        Pedido pedido = new Pedido();
        pedido.setStatus(this.getStatus());
        return pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
