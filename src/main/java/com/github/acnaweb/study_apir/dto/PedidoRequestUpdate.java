package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Pedido;

public class PedidoRequestUpdate {
    private String status;

    public Pedido toModel(Pedido o){
        o.setStatus(this.getStatus());
        return o;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
