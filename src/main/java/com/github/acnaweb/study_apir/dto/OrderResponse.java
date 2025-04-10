package com.github.acnaweb.study_apir.dto;
import com.github.acnaweb.study_apir.model.Order;
public class OrderResponse {
    private Long id;
    private String status;

    public OrderResponse toDto(Order order){
        this.setId(order.getId());
        this.setStatus(order.getStatus());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
