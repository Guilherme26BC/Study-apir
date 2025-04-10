package com.github.acnaweb.study_apir.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Item {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long item_id;

   @ManyToOne
   private Order order;
   @ManyToOne
   private Product product;

   private int quantity;
   private BigDecimal value;

}
