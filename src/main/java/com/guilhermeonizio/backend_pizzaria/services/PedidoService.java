package com.guilhermeonizio.backend_pizzaria.services;

import com.guilhermeonizio.backend_pizzaria.entities.Pedido;
import com.guilhermeonizio.backend_pizzaria.entities.StatusPedido;
import com.guilhermeonizio.backend_pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido (Pedido pedido) {
        pedido.setStatus(StatusPedido.RECEBIDO);
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarStatus(Long id, StatusPedido status) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidosPorStatus(StatusPedido status) {
        return pedidoRepository.findByStatus(status);
    }

}
