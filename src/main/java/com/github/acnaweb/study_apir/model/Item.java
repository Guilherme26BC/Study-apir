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
