package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Item;
import com.github.acnaweb.study_apir.model.Order;
import com.github.acnaweb.study_apir.model.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class ItemResponse {
    private Long item_id;
    private Order order;
    private Product product;
    private int quantity;
    private BigDecimal value;

    public ItemResponse toDto(Item item){
        this.setItem_id(item.getItem_id());
        this.setOrder(item.getOrder());
        this.setProduct(item.getProduct());
        this.setQuantity(item.getQuantity());
        this.setValue(item.getValue());
        return this;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
