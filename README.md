# :star2: Pizzaria - Sistema de Gerenciamento de Pedidos

Este projeto é um sistema de gerenciamento de pedidos para uma pizzaria, desenvolvido em Java 17 com Spring Boot. Ele permite o cadastro de clientes, pizzas e pedidos, além de gerenciar o status dos pedidos. O sistema é uma API RESTful que pode ser consumida por um front-end ou aplicativo móvel.

## Funcionalidades

- Clientes:
  - Cadastrar, listar, buscar, atualizar e excluir clientes.
- Pizzas:
  - Cadastrar, listar, buscar, atualizar e excluir pizzas.
- Pedidos:
  - Criar pedidos associados a um cliente e uma lista de pizzas.
  - Atualizar o status do pedido (ex.: "Recebido", "Em preparo", "Pronto", "Entregue").
  - Listar pedidos por status.

## Tecnologias Utilizadas

- Java 17: Linguagem de programação principal.
- Spring Boot: Framework para construção da aplicação.
- Spring Data JPA: Para persistência de dados.
- H2 Database: Banco de dados em memória para teste.
- PostgreSQL: Banco de dados relacional para desenvolvimento.
- Maven: Gerenciamento de dependências.
- Lombok: Para reduzir código boilerplate.
- Bean Validation: Para validação de dados de entrada.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- Java 17: Download JDK 17
- Maven: Instalação do Maven
- PostgreSQL (opcional para Desenvolvimento): Download PostgreSQL

## Passos para rodar o projeto

1. Clone este repositório:

   ```bash
    git clone https://github.com/GuilhermeOnizio/backend-pizzaria.git
   ```

2. Entre na pasta do projeto:

   ```bash
    cd backend-pizzaria
   ```

3. Configure o Banco de Dados

Teste (H2 Database)

O projeto já está configurado para usar o H2 Database em desenvolvimento. Nenhuma configuração adicional é necessária.

Desenvolvimento (PostgreSQL)

Crie um banco de dados no PostgreSQL:
   ```sql
    CREATE DATABASE pizzaria;
   ```

4. Instale as Dependências:

   ```bash
    mvn clean install
   ```


## Endpoints Principais

### /clientes
  - GET /clientes: Listar todos os clientes.
  - GET /clientes/{id}: Buscar um cliente pelo ID.
  - POST /clientes: Criar um novo cliente.
  - PUT /clientes/{id}: Atualizar um cliente existente.
  - DELETE /clientes/{id}: Excluir um cliente.

### /pizzas
  - GET /pizzas: Listar todas as pizzas.
  - GET /pizzas/{id}: Buscar uma pizza pelo ID.
  - POST /pizzas: Criar uma nova pizza.
  - PUT /pizzas/{id}: Atualizar uma pizza existente.
  - DELETE /pizzas/{id}: Excluir uma pizza.

### /pedidos
  - GET /pedidos: Listar todos os pedidos.
  - GET /pedidos/{id}: Buscar um pedido pelo ID.
  - POST /pedidos: Criar um novo pedido.
  - PUT /pedidos/{id}/status: Atualizar o status de um pedido.
  - DELETE /pedidos/{id}: Excluir um pedido.

## Exemplos de Requisições

Criar um Cliente
- Método: POST
- URL: http://localhost:8080/clientes

Body:
   ```json
    {
      "nome": "João Silva",
      "telefone": "11999999999",
      "endereco": "Rua das Flores, 123"
    }
   ```

Criar um Pedido
- Método: POST
- URL: http://localhost:8080/pedidos

Body:
   ```json
    {
      "cliente": {
        "id": 1
      },
      "pizzas": [
        {
          "id": 1
        },
        {
          "id": 2
        }
      ],
      "total": 50.0
    }
   ```

Atualizar o Status de um Pedido
- Método: PUT
- URL: http://localhost:8080/pedidos/1/status?status=EM_PREPARO
