package com.github.acnaweb.study_apir.controller;

import com.github.acnaweb.study_apir.dto.OrderRequestCreate;
import com.github.acnaweb.study_apir.dto.OrderRequestUpdate;
import com.github.acnaweb.study_apir.dto.OrderResponse;
import com.github.acnaweb.study_apir.model.Order;
import com.github.acnaweb.study_apir.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class ControllerOrder {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequestCreate dto){
        return ResponseEntity.status(201).body(
                new OrderResponse().toDto(orderService.createOrder(dto)));
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
         if(orderService.deleteOrder(id)){
             return ResponseEntity.ok().build();
         }else{
         return ResponseEntity.notFound().build();
         }
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> update(@PathVariable Long id, @RequestBody OrderRequestUpdate dto){
        return orderService.updateOrder(id, dto)
                .map(orderUpdated ->  new OrderResponse().toDto(orderUpdated))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll(){
        List<OrderResponse> responses = orderService.getAll().stream()
                .map(o-> new OrderResponse().toDto(o))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable Long id){
     return orderService.getOrderById(id)
             .map(orderGet-> new OrderResponse().toDto(orderGet))
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
    }
}
