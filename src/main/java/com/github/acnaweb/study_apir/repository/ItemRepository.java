package com.github.acnaweb.study_apir.repository;

import com.github.acnaweb.study_apir.model.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Itens, Long> {
}
