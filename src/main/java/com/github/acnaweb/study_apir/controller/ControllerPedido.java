package com.github.acnaweb.study_apir.controller;

import com.github.acnaweb.study_apir.dto.item.ItemResponse;
import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestCreate;
import com.github.acnaweb.study_apir.dto.pedido.PedidoRequestUpdate;
import com.github.acnaweb.study_apir.dto.pedido.PedidoResponse;
import com.github.acnaweb.study_apir.model.Pedido;
import com.github.acnaweb.study_apir.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pedidos")
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
//        List<PedidoResponse> responses = pedidoService.buscarTodos().stream()
//                .map(o-> new PedidoResponse().toDto(o))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(responses);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> buscarPorId(@PathVariable Long id){
//     return pedidoService.buscarPedidoPorId(id)
//             .map(orderGet-> new PedidoResponse().toDto(orderGet))
//             .map(ResponseEntity::ok)
//             .orElse(ResponseEntity.notFound().build());
        return ResponseEntity.noContent().build();
    }
}
