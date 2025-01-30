package com.guilhermeonizio.backend_pizzaria.dto;

import com.guilhermeonizio.backend_pizzaria.entities.Cliente;
import com.guilhermeonizio.backend_pizzaria.entities.StatusPedido;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class PedidoDTO {

    private Long id;

    @NotNull(message = "O cliente é obrigatório")
    private Cliente cliente;

    @NotNull(message = "A lista de pizzas é obrigatória")
    private List<PizzaDTO> pizzas;

    @NotNull(message = "O total é obrigatório")
    @Positive(message = "O total deve ser um valor positivo")
    private Double total;

    @NotNull(message = "O status é obrigatório")
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
