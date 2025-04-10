package com.github.acnaweb.study_apir.repository;

import com.github.acnaweb.study_apir.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
