package com.guilhermeonizio.backend_pizzaria.repository;

import com.guilhermeonizio.backend_pizzaria.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
