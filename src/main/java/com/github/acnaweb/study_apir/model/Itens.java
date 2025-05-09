package com.github.acnaweb.study_apir.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.math.BigDecimal;

@Entity
public class Itens {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long item_id;

   @ManyToOne
   @Cascade(value = CascadeType.ALL)
   @JoinColumn(name ="pedido_id")
   private Pedido pedido;

   @ManyToOne
   @Cascade(value = CascadeType.ALL) //
   @JoinColumn(name ="produto_id")
   private Produtos produto;

   private BigDecimal quantidade;
   private BigDecimal valor;

   public Long getItem_id() {
      return item_id;
   }

   public void setItem_id(Long item_id) {
      this.item_id = item_id;
   }

   public Pedido getPedido() {
      return pedido;
   }

   public void setPedido(Pedido pedido) {
      this.pedido = pedido;
   }

   public Produtos getProduto() {
      return produto;
   }

   public void setProduto(Produtos produtos) {
      this.produto = produtos;
   }

   public BigDecimal getQuantidade() {
      return quantidade;
   }

   public void setQuantidade(BigDecimal quantidade) {
      this.quantidade = quantidade;
   }

   public BigDecimal getValor() {
      return valor;
   }

   public void setValor(BigDecimal valor) {
      this.valor = valor;
   }
}
