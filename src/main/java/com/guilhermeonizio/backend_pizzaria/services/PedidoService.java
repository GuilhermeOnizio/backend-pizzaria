package com.guilhermeonizio.backend_pizzaria.services;

import com.guilhermeonizio.backend_pizzaria.dto.PedidoDTO;
import com.guilhermeonizio.backend_pizzaria.dto.PizzaDTO;
import com.guilhermeonizio.backend_pizzaria.entities.Pedido;
import com.guilhermeonizio.backend_pizzaria.entities.StatusPedido;
import com.guilhermeonizio.backend_pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public Pedido buscarPedido(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus(StatusPedido.RECEBIDO);
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public PedidoDTO atualizarStatusPedido(Long id, StatusPedido status) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setStatus(status);
        pedidoRepository.save(pedido);

        return toDTO(pedido);
    }

    private PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setCliente(pedido.getCliente());
        pedidoDTO.setTotal(pedido.getTotal());
        pedidoDTO.setStatus(pedido.getStatus());

        // Converte as pizzas para DTO
        List<PizzaDTO> pizzasDTO = pedido.getPizzas().stream()
                .map(pizza -> {
                    PizzaDTO pizzaDTO = new PizzaDTO();
                    pizzaDTO.setId(pizza.getId());
                    pizzaDTO.setNome(pizza.getNome());
                    pizzaDTO.setIngredientes(pizza.getIngredientes());
                    pizzaDTO.setPreco(pizza.getPreco());
                    return pizzaDTO;
                })
                .collect(Collectors.toList());

        pedidoDTO.setPizzas(pizzasDTO);

        return pedidoDTO;
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

}
