# Elionardo Silva dos Santos



### Serratec API Rest - Projeto Individual
<br>

## Visão Geral

Esta aplicação é uma API REST desenvolvida em Java com Spring Boot para gerenciar um sistema de cursos comunitários.
O projeto inclui recursos para as entidades:

- `Aluno`
- `Curso`
- `Professor`
- `PerfilSocial`

A aplicação utiliza Spring Web MVC, Spring Data JPA, validação de dados e documentação OpenAPI/Swagger.

## Tecnologias

- Java 17
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- Bean Validation
- PostgreSQL (runtime)
- SpringDoc OpenAPI / Swagger UI
- Maven

## Estrutura do Projeto

- `src/main/java/org/serratec/curso/controller` - controladores REST
- `src/main/java/org/serratec/curso/domain` - entidades do domínio
- `src/main/java/org/serratec/curso/dto` - objetos de transporte de dados (DTOs)
- `src/main/java/org/serratec/curso/service` - regras de negócio e serviços
- `src/main/java/org/serratec/curso/repository` - repositórios JPA
- `src/main/java/org/serratec/curso/exception` - tratamento de exceções
- `src/main/java/org/serratec/curso/config` - configuração da API e OpenAPI

## Configuração

A aplicação lê as configurações do banco de dados em `src/main/resources/application.properties`.

> Ajuste `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` conforme seu ambiente.

## Execução

No diretório do projeto, use Maven:

```bash
./mvnw spring-boot:run
```

Ou para compilar e gerar o JAR:

```bash
./mvnw clean package
```

Em seguida execute:

```bash
java -jar target/curso-0.0.1-SNAPSHOT.jar
```

## Documentação da API

Após iniciar a aplicação, a documentação OpenAPI/Swagger estará disponível em:

- `http://localhost:8080/swagger-ui.html`
- `http://localhost:8080/v3/api-docs`

## Observações

- A aplicação usa `spring.jpa.hibernate.ddl-auto=update`, o que atualiza a estrutura do banco automaticamente a partir das entidades.
- A opção `spring.jackson.deserialization.fail-on-unknown-properties=true` garante que requisições com campos extras retornem `400 Bad Request`.

## Contato

Projeto desenvolvido como trabalho individual do curso Serratec.
