package com.guilhermeonizio.backend_pizzaria.controllers;

import com.guilhermeonizio.backend_pizzaria.entities.Pizza;
import com.guilhermeonizio.backend_pizzaria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<Pizza> listarPizzas() {
        return pizzaService.listarPizzas();
    }

    @GetMapping("/{id}")
    public Pizza buscarPizza(@PathVariable Long id) {
        return pizzaService.buscarPizza(id);
    }

    @PostMapping
    public Pizza criarPizza(@RequestBody Pizza pizza) {
        return pizzaService.criarPizza(pizza);
    }

    @PutMapping("/{id}")
    public Pizza atualizarPizza(@PathVariable Long id, @RequestBody Pizza pizza) {
        return pizzaService.atualizarPizza(id, pizza);
    }

    @DeleteMapping("/{id}")
    public void excluirPizza(@PathVariable Long id) {
        pizzaService.excluirPizza(id);
    }
}
