package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Order;

public class OrderRequestCreate {
    private String status;

    public Order toModel(){
        Order order = new Order();
        order.setStatus(this.getStatus());
        return order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
