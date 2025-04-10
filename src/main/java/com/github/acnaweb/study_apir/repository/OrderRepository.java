package com.github.acnaweb.study_apir.repository;

import com.github.acnaweb.study_apir.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
