package com.guilhermeonizio.backend_pizzaria.dto;

import com.guilhermeonizio.backend_pizzaria.entities.Cliente;
import com.guilhermeonizio.backend_pizzaria.entities.StatusPedido;

import java.util.List;

public class PedidoDTO {
    private Long id;
    private Cliente cliente;
    private List<PizzaDTO> pizzas;
    private Double total;
    private StatusPedido status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<PizzaDTO> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaDTO> pizzas) {
        this.pizzas = pizzas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
