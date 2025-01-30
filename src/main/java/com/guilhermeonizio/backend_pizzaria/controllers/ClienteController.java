package com.guilhermeonizio.backend_pizzaria.controllers;

import com.guilhermeonizio.backend_pizzaria.dto.ClienteDTO;
import com.guilhermeonizio.backend_pizzaria.entities.Cliente;
import com.guilhermeonizio.backend_pizzaria.services.ClienteService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarCliente(@PathVariable Long id) {
        return clienteService.buscarCliente(id);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

}
