package com.guilhermeonizio.backend_pizzaria.services;

import com.guilhermeonizio.backend_pizzaria.dto.ClienteDTO;
import com.guilhermeonizio.backend_pizzaria.entities.Cliente;
import com.guilhermeonizio.backend_pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarCliente(Long id) {
        Cliente cliente =  clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return toDTO(cliente);
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return toDTO(cliente);
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setTelefone(clienteDTO.getTelefone());
        clienteExistente.setEndereco(clienteDTO.getEndereco());

        clienteExistente = clienteRepository.save(clienteExistente);
        return toDTO(clienteExistente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    private Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());
        return cliente;
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteDTO.getId());
        clienteDTO.setNome(clienteDTO.getNome());
        clienteDTO.setTelefone(clienteDTO.getTelefone());
        clienteDTO.setEndereco(clienteDTO.getEndereco());
        return clienteDTO;
    }

}
