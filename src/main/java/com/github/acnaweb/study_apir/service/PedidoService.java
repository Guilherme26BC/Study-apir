package com.github.acnaweb.study_apir.service;

import com.github.acnaweb.study_apir.dto.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.PedidoRequestUpdate;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(PedidoRequestCreate dto){
        return pedidoRepository.save(dto.toModel());
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
}
