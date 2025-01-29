package com.guilhermeonizio.backend_pizzaria.repository;

import com.guilhermeonizio.backend_pizzaria.entities.Pedido;
import com.guilhermeonizio.backend_pizzaria.entities.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido status);
}
