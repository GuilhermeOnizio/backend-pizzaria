package com.guilhermeonizio.backend_pizzaria.controllers;

import com.guilhermeonizio.backend_pizzaria.dto.PedidoDTO;
import com.guilhermeonizio.backend_pizzaria.entities.Pedido;
import com.guilhermeonizio.backend_pizzaria.entities.StatusPedido;
import com.guilhermeonizio.backend_pizzaria.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPedido(@PathVariable Long id) {
        return pedidoService.buscarPedido(id);
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @PutMapping("/{id}/status")
    public PedidoDTO atualizarStatusPedido(@PathVariable Long id, @RequestParam StatusPedido status) {
        return pedidoService.atualizarStatusPedido(id, status);
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
    }

}
