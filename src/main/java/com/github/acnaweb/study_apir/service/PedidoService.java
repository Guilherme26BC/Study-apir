package com.github.acnaweb.study_apir.service;

import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestUpdate;
import com.github.acnaweb.study_apir.model.Itens;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.model.PedidoStatus;
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
        return pedidoRepository.save(dto.toModel(produtoRepository));
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
    public List<Pedido> findByStatus(PedidoStatus status){
        return pedidoRepository.findByStatus(status);
    }
}
