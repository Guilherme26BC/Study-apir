package com.github.acnaweb.study_apir.dto;

import java.math.BigDecimal;

public class ItemRequestUpdate {
    private int quantity;
    private BigDecimal value;

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
