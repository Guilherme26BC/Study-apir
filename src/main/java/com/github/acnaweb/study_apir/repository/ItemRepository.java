package com.github.acnaweb.study_apir.repository;

import com.github.acnaweb.study_apir.model.Itens;
import com.github.acnaweb.study_apir.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Itens, Long> {

}
