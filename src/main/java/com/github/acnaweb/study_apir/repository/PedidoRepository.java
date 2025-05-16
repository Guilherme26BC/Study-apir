package com.github.acnaweb.study_apir.repository;

import com.github.acnaweb.study_apir.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    //select p.* rom pedido p were p.status ='?' Script do findByStatus
    public List<Pedido> findByStatus(String status);

}
