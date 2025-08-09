# Projeto Financeiro - Estrutura Hexagonal

Este projeto implementa um sistema financeiro utilizando **Java** e **Spring Boot**, seguindo a arquitetura **Hexagonal** (Ports and Adapters).  

---

## Estrutura de Pastas

```plaintext
src
 └── main
     ├── java
     │    └── com
     │         └── seuusuario
     │              └── financeiro
     │                   ├── application                # Camada de aplicação (casos de uso)
     │                   │    ├── ports
     │                   │    │    ├── in               # Portas de entrada (interfaces chamadas pelo mundo externo)
     │                   │    │    │    └── RegistrarReceitaUseCase.java
     │                   │    │    └── out              # Portas de saída (interfaces para adaptadores externos)
     │                   │    │         └── ReceitaRepositoryPort.java
     │                   │    └── service               # Implementações dos casos de uso
     │                   │         └── ReceitaService.java
     │                   │
     │                   ├── domain                     # Camada de domínio (regras de negócio puras)
     │                   │    ├── model                 # Entidades e Value Objects
     │                   │    │    └── Receita.java
     │                   │    ├── builder               # Builders para criar objetos de domínio (substituídos por Lombok)
     │                   │    │    └── ReceitaBuilder.java
     │                   │    └── exceptions            # Exceções de domínio
     │                   │         └── SaldoInsuficienteException.java
     │                   │
     │                   ├── infrastructure             # Camada de infraestrutura (adaptadores externos)
     │                   │    ├── config                # Configurações Spring, Beans
     │                   │    │    └── SwaggerConfig.java
     │                   │    ├── persistence           # Persistência (Banco de Dados)
     │                   │    │    ├── entity           # Entidades JPA
     │                   │    │    │    └── ReceitaEntity.java
     │                   │    │    ├── repository       # Implementações dos Ports de saída
     │                   │    │    │    └── ReceitaRepositoryAdapter.java
     │                   │    │    └── converter        # Converters Entity ↔ Domínio
     │                   │    │         └── ReceitaEntityConverter.java
     │                   │    ├── rest                  # Controllers REST
     │                   │    │    ├── controller
     │                   │    │    │    └── ReceitaController.java
     │                   │    │    ├── dto              # DTOs para entrada/saída da API
     │                   │    │    │    └── ReceitaDTO.java
     │                   │    │    └── converter        # Converters DTO ↔ Domínio
     │                   │    │         └── ReceitaDtoConverter.java
     │                   │    └── messaging             # Mensageria (Kafka, RabbitMQ)
     │                   │         └── ReceitaEventPublisher.java
     │                   │
     │                   └── shared                     # Código compartilhado
     │                        ├── utils
     │                        │    └── DataUtils.java
     │                        └── constants
     │                             └── MensagensErro.java
     │
     └── test
          └── java
               └── com
                    └── seuusuario
                         └── financeiro
                              ├── fixture               # Fixtures para testes
                              │    └── ReceitaFixture.java
                              ├── unit                   # Testes unitários
                              │    └── ReceitaServiceTest.java
                              └── integration            # Testes de integração
                                   └── ReceitaControllerIT.java
