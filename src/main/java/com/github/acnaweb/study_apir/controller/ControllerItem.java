package com.github.acnaweb.study_apir.controller;

import com.github.acnaweb.study_apir.dto.ItemRequestCreate;
import com.github.acnaweb.study_apir.dto.ItemRequestUpdate;
import com.github.acnaweb.study_apir.dto.ItemResponse;
import com.github.acnaweb.study_apir.dto.OrderResponse;
import com.github.acnaweb.study_apir.model.Item;
import com.github.acnaweb.study_apir.service.ItemService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("itens")
public class ControllerItem {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequestCreate dto){
        return ResponseEntity.status(201)
                .body(new ItemResponse().toDto(itemService.create()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemResponse> update(@PathVariable Long id, @RequestBody ItemRequestUpdate dto){
        return itemService.update(id, dto).
                map(itemUpdate ->  new ItemResponse().toDto(itemUpdate))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getById(@PathVariable Long id){
        return itemService.getItemById(id)
                .map(itemGet-> new ItemResponse().toDto(itemGet))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAll(){
        List<ItemResponse> responses = itemService.getAll().stream()
                .map(itens-> new ItemResponse().toDto(itens))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(itemService.deleteItem(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
