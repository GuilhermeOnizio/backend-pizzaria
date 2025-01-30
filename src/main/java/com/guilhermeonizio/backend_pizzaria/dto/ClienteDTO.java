package com.guilhermeonizio.backend_pizzaria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ClienteDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "Os ingredientes são obrigatórios")
    private String telefone;

    @NotNull(message = "O endereço é obrigatório")
    private String endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
