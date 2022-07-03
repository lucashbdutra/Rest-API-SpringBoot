# Rest-API-SpringBoot
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/lucashbdutra/Rest-API-SpringBoot/blob/main/LICENSE) 

Projeto de uma API restful no framework SpringBoot.

## Sobre o projeto

A API "spring-market" que é basicamente uma lista de produtos onde você pode adicionar produtos (com nome, preço e a qual categoria pertence) e categorias de produtos(apenas o nome da categoria).Você pode ter várias categorias e cada uma tem uma lista de produtos em seu interior, permitindo uma maior conexão entre as entidades da API. Contendo todos os principais métodos REST: GET, POST, PUT e DELETE.

Além de uma API secundária "market-consumer" que consome os dados da primeira utilizando o "en Feign", conseguindo trazer dados dos principais métodos disponíveis na API principal, tais como GET, POST, PUT e DELETE.

## Tecnologias utilizadas
### Back end
- Java
- Spring Boot
- JPA / Hibernate / H2
- Open Feign
- Maven

## Como executar o projeto

### Back end
Pré-requisitos: Java 17

```bash
## clonar repositório
git clone https://github.com/lucashbdutra/Rest-API-SpringBoot

## entrar na pasta do projeto que você quer executar
cd path-to-file

## executar o projeto
./mvnw spring-boot:run
```

## Testes

Os testes unit�rios em sua maioria est�o com 100% de cobertura. Focados principalmente nos services e nos resources.

## Documentação

spring-market:
https://documenter.getpostman.com/view/19190144/UVkqqtrC
http://localhost:8080/swagger-ui/index.html

spring-consumer:
https://documenter.getpostman.com/view/19190144/UVkqqtrE
http://localhost:8081/swagger-ui/index.html

# Autor

Lucas Dutra

https://www.linkedin.com/in/lucas-dutra-8b41681b7/
