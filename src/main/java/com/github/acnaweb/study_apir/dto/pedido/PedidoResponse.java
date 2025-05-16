package com.github.acnaweb.study_apir.dto.pedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.acnaweb.study_apir.dto.item.ItemResponse;
import com.github.acnaweb.study_apir.model.Itens;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.model.PedidoStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoResponse {
    private Long id;
    private String status;
    private List<ItemResponse> itens;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataEntrega;

    public PedidoResponse toDto(Pedido pedido) {
        this.setId(pedido.getId());
        this.setStatus(pedido.getStatus().getMensagem());
        this.setDataEntrega(pedido.getDataEntrega());

        List<ItemResponse> items = pedido.getItems()
                .stream()
                .map(item -> new ItemResponse().toDto(item))
                .collect(Collectors.toList());

        this.setItens(items);
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

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
