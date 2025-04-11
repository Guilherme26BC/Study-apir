package com.github.acnaweb.study_apir.dto.pedido;

import com.github.acnaweb.study_apir.dto.item.ItemRequestCreate;
import com.github.acnaweb.study_apir.model.Itens;
import com.github.acnaweb.study_apir.model.Pedido;

import java.util.List;

public class PedidoRequestCreate {
    private List<ItemRequestCreate> itens;

    public Pedido toModel(){
        Pedido pedido = new Pedido();
        pedido.setStatus("ABERTO");

        return pedido;
    }

    public List<ItemRequestCreate> getItens() {
        return itens;
    }

    public void setItens(List<ItemRequestCreate> itens) {
        this.itens = itens;
    }
}
