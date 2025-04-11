package com.github.acnaweb.study_apir.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;

    @OneToMany
    private List<Itens> items;
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

    public List<Itens> getItems() {
        return items;
    }

    public void setItems(List<Itens> items) {
        this.items = items;
    }
}
