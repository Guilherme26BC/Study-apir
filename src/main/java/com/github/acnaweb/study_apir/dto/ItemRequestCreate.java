package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Item;
import com.github.acnaweb.study_apir.model.Product;
import com.github.acnaweb.study_apir.service.ProductService;

import java.math.BigDecimal;

public class ItemRequestCreate {
    private Product product;
    private int quantity;
    private BigDecimal value;

    public Item toModel(){
       Item item = new Item();
       item.setQuantity(quantity);
       item.setValue(value);
        return item;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
