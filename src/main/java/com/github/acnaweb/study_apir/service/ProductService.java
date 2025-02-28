package com.github.acnaweb.study_apir.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apir.model.Product;
@Service
public class ProductService {
    private List<Product> products;

    public Product createProduct(Product product){
       //products.add(product);
        return null;
    }
    public Product getProductById(Long id){
        //    Product product = products.get(id);
        return null;
    }
    public Product updateProduct(Long id, Product product){
        return null;
    }
    public void deleteProduct(Long id){

    }
}
