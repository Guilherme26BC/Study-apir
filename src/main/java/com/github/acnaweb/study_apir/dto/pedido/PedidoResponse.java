package com.github.acnaweb.study_apir.dto.pedido;
import com.github.acnaweb.study_apir.dto.item.ItemResponse;
import com.github.acnaweb.study_apir.model.Itens;
import com.github.acnaweb.study_apir.model.Pedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoResponse {
    private Long id;
    private String status;
    private List<ItemResponse> itens;

    public PedidoResponse toDto(Pedido pedido){
        this.setId(pedido.getId());
        this.setStatus(pedido.getStatus());

        List<ItemResponse> itensResponse = pedido.getItems()
                .stream().map(item -> new ItemResponse().toDto(item)).collect(Collectors.toList());

        this.setItens(itensResponse);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemResponse> getItens() {
        return itens;
    }

    public void setItens(List<ItemResponse> itens) {
        this.itens = itens;
    }
}
