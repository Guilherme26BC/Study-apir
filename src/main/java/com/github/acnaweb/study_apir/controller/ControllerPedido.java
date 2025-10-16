package com.github.acnaweb.study_apir.controller;

import com.github.acnaweb.study_apir.dto.item.ItemResponse;
import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestUpdate;
import com.github.acnaweb.study_apir.dto.pedido.PedidoResponse;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.model.PedidoStatus;
import com.github.acnaweb.study_apir.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/${api.version}/pedidos")
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@RequestBody PedidoRequestCreate dto) {
    return ResponseEntity.ok().body(new PedidoResponse().toDto(pedidoService.criarPedido(dto)));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deletar(@PathVariable Long id){
         if(pedidoService.deletarPedido(id)){
             return ResponseEntity.ok().build();
         }else{
         return ResponseEntity.notFound().build();
         }
    }
    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> atualizar(@PathVariable Long id, @RequestBody PedidoRequestUpdate dto){
        return pedidoService.atualizarPedido(id, dto)
                .map(orderUpdated ->  new PedidoResponse().toDto(orderUpdated))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> buscarTodos(){
        return ResponseEntity.ok(pedidoService.buscarTodos().stream()
                .map(pedido -> new PedidoResponse().toDto(pedido))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable Long id){

        return pedidoService.buscarPedidoPorId(id)
                .map(new PedidoResponse()::toDto)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //Query parameter
    @GetMapping("query")
    public ResponseEntity<List<PedidoResponse>> findByStatus(PedidoStatus status){
        return ResponseEntity.ok(pedidoService.findByStatus(status).stream()
                .map(pedido -> new PedidoResponse().toDto(pedido))
                .collect(Collectors.toList()));
    }
}
