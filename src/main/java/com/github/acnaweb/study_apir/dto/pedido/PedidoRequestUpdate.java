package com.github.acnaweb.study_apir.dto.pedido;

import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.model.PedidoStatus;

public class PedidoRequestUpdate {
    private PedidoStatus status;

    public Pedido toModel(Pedido o){
        o.setStatus(this.getStatus());
        return o;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }
}
