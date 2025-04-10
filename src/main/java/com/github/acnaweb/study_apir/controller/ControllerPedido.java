package com.github.acnaweb.study_apir.controller;

import com.github.acnaweb.study_apir.dto.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.PedidoRequestUpdate;
import com.github.acnaweb.study_apir.dto.PedidoResponse;
import com.github.acnaweb.study_apir.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponse> criar(@RequestBody PedidoRequestCreate dto){
        return ResponseEntity.status(201).body(
                new PedidoResponse().toDto(pedidoService.criarPedido(dto)));
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
    public ResponseEntity<PedidoResponse> atualziar(@PathVariable Long id, @RequestBody PedidoRequestUpdate dto){
        return pedidoService.atualizarPedido(id, dto)
                .map(orderUpdated ->  new PedidoResponse().toDto(orderUpdated))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> buscarTodos(){
        List<PedidoResponse> responses = pedidoService.buscarTodos().stream()
                .map(o-> new PedidoResponse().toDto(o))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable Long id){
     return pedidoService.buscarPedidoPorId(id)
             .map(orderGet-> new PedidoResponse().toDto(orderGet))
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
    }
}
