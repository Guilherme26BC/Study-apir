package com.github.acnaweb.study_apir.dto.pedido;

import java.util.List;
import java.util.stream.Collectors;

import com.github.acnaweb.study_apir.dto.item.ItemRequestCreate;
import com.github.acnaweb.study_apir.model.Itens;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.model.Produtos;
import com.github.acnaweb.study_apir.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoRequestCreate {
    private List<ItemRequestCreate> items;

    public Pedido toModel(ProdutoRepository produtoRepository){
        Pedido pedido = new Pedido();
        pedido.setStatus("Aberto");
        //mapear os itens
        List<Itens> items = this.getItens().stream()
                .map(i -> { //lambda para transformar itemRequest em itens
                    Produtos produto = produtoRepository
                            .findById(i.getProduto_id())
                            .orElseThrow(() ->
                                    new RuntimeException("Produto inexistente: " + i.getProduto_id()));
                    return  i.toModel(produto, pedido);
                }).collect(Collectors.toList());
        pedido.setItems(items);
        return pedido;
    }

    public List<ItemRequestCreate> getItens() {
        return items;
    }

    public void setItens(List<ItemRequestCreate> items) {
        this.items = items;
    }

}


















