package com.github.acnaweb.study_apir.dto;

import com.github.acnaweb.study_apir.model.Order;

public class OrderRequestUpdate {
    private String status;

    public Order toModel(Order o){
        o.setStatus(this.getStatus());
        return o;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
