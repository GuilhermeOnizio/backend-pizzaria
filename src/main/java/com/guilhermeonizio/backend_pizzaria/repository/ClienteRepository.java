package com.guilhermeonizio.backend_pizzaria.repository;

import com.guilhermeonizio.backend_pizzaria.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
