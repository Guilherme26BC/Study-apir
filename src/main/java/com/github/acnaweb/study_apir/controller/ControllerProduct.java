    package com.github.acnaweb.study_apir.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import com.github.acnaweb.study_apir.dto.ProductRequestCreate;
import com.github.acnaweb.study_apir.dto.ProductRequestUpdate;
import com.github.acnaweb.study_apir.model.Product;
import com.github.acnaweb.study_apir.service.ProductService;

@RestController
@RequestMapping("produtos")
public class ControllerProduct {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequestCreate dto) {
        Product productCreate = productService.createProduct(dto);
        return ResponseEntity.status(201).body(productCreate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = productService.deleteProduct(id);
        if(result){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.notFound().build();
        }
        

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductRequestUpdate dto) {
            return productService.updateProduct(id,dto)
            .map(ResponseEntity ::ok)
            .orElse(ResponseEntity.notFound().build());

        // Optional<Product> productUpdated = productService.updateProduct(id,product);
        // if(productUpdated.isPresent()){
        //     return ResponseEntity.ok(productUpdated.get());        
        // }
        // return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return productService.getProductById(id)
        .map(ResponseEntity:: ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Product>> findByAll() {
       return ResponseEntity.ok(productService.getAll());
    }
}
