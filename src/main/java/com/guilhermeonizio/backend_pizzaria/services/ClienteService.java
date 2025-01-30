package com.guilhermeonizio.backend_pizzaria.services;

import com.guilhermeonizio.backend_pizzaria.entities.Cliente;
import com.guilhermeonizio.backend_pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = buscarCliente(id);
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setEndereco(cliente.getEndereco());
        return clienteRepository.save(clienteExistente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
