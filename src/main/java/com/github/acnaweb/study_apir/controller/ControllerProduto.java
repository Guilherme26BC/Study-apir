    package com.github.acnaweb.study_apir.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.github.acnaweb.study_apir.dto.produto.ProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_apir.dto.produto.ProdutoRequestCreate;
import com.github.acnaweb.study_apir.dto.produto.ProdutoRequestUpdate;
import com.github.acnaweb.study_apir.service.ProdutoService;

@RestController
@RequestMapping("/api/${api.version}/produtos")
public class ControllerProduto {
    
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponse> criar(@RequestBody ProdutoRequestCreate dto) {
         return ResponseEntity.status(201).body(
                 new ProdutoResponse().toDto(produtoService.criarProduto(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if(produtoService.deletarProduto(id)){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.notFound().build();
        }
        

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id, @RequestBody ProdutoRequestUpdate dto) {
            return produtoService.atualizarProduto(id,dto)
            .map(productUpdated->new ProdutoResponse().toDto(productUpdated))
            .map(ResponseEntity ::ok)
            .orElse(ResponseEntity.notFound().build());

        // Optional<Product> productUpdated = produtoService.updateProduct(id,product);
        // if(productUpdated.isPresent()){
        //     return ResponseEntity.ok(productUpdated.get());        
        // }
        // return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
        .map(productGet-> new ProdutoResponse().toDto(productGet))
        .map(ResponseEntity:: ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> buscarTodos() {
       List<ProdutoResponse> response= produtoService.buscarTodos().stream()
                .map(p-> new ProdutoResponse().toDto(p))
                .collect(Collectors.toList());
       return ResponseEntity.ok(response);
    }
}
