package com.guilhermeonizio.backend_pizzaria.services;

import com.guilhermeonizio.backend_pizzaria.entities.Cliente;
import com.guilhermeonizio.backend_pizzaria.entities.Pizza;
import com.guilhermeonizio.backend_pizzaria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> listarPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza buscarPizza(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza não encontrada"));
    }

    public Pizza criarPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza atualizarPizza(Long id, Pizza pizza) {
        Pizza pizzaExistente = buscarPizza(id);
        pizzaExistente.setNome(pizza.getNome());
        pizzaExistente.setIngredientes(pizza.getIngredientes());
        pizzaExistente.setPreco(pizza.getPreco());
        return pizzaRepository.save(pizzaExistente);
    }

    public void excluirPizza(Long id) {
        pizzaRepository.deleteById(id);
    }

}
