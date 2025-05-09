package com.github.acnaweb.study_apir.service;

import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestUpdate;
import com.github.acnaweb.study_apir.model.Itens;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.model.Produtos;
import com.github.acnaweb.study_apir.repository.ItemRepository;
import com.github.acnaweb.study_apir.repository.PedidoRepository;
import com.github.acnaweb.study_apir.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemRepository itemRepository;

    public Pedido criarPedido(PedidoRequestCreate dto){
        Pedido pedido = new Pedido();
        pedido.setStatus("Aberto");
        //mapear os itens
        List<Itens> items = dto.getItens().stream()
                .map(i -> { //lambda para transformar itemRequest em itens
                    Itens item = new Itens();
                    Produtos produto = produtoRepository
                            .findById(i.getProduto_id())
                            .orElseThrow(() ->
                                    new RuntimeException("Produto inexistente: " + i.getProduto_id()));

                    item.setProduto(produto);
                    item.setValor(i.getValor());
                    item.setQuantidade(i.getQuantidade());
                    item.setPedido(pedido);
                    return  item;
                }).collect(Collectors.toList());
        pedido.setItems(items);
        return pedidoRepository.save(pedido);
    }
    public Optional<Pedido> buscarPedidoPorId(Long id){
        return pedidoRepository.findById(id);
    }

    public List<Pedido> buscarTodos(){
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> atualizarPedido(Long id, PedidoRequestUpdate dto){

        return pedidoRepository.findById(id)
            .map(o-> pedidoRepository.save(dto.toModel(o)));
    }
    public boolean deletarPedido(Long id){
    if(pedidoRepository.existsById(id)){
        pedidoRepository.deleteById(id);
        return true;
    }
        return false;
    }
    public List<Pedido> findByStatus(String status){
        return pedidoRepository.findByStatus(status);
    }
}
