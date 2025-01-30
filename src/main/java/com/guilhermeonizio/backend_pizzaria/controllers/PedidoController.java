package com.guilhermeonizio.backend_pizzaria.controllers;

import com.guilhermeonizio.backend_pizzaria.entities.Pedido;
import com.guilhermeonizio.backend_pizzaria.entities.StatusPedido;
import com.guilhermeonizio.backend_pizzaria.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestParam StatusPedido status) {
        return pedidoService.atualizarStatus(id, status);
    }

    @GetMapping("/status")
    public List<Pedido> listarPedidosPorStatus(@RequestParam StatusPedido status) {
        return pedidoService.listarPedidosPorStatus(status);
    }

}
