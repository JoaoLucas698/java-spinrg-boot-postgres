# java-spring-boot-postgres

Esta é uma aplicação CRUD que cria tarefas com título, descrição e data de finalização. A API roda na `localhost:8080`.

## Pré-requisitos

- Java 17
- Maven

## Configuração do Projeto

### Instalar Maven Wrapper (se necessário)

Se o Maven Wrapper ainda não estiver configurado no projeto, execute o seguinte comando na raiz do projeto:

mvn -N io.takari:maven:wrapper

## Executar a Aplicação

Para iniciar a aplicação, use o comando abaixo na raiz do projeto:

mvn clean install && ./mvnw spring-boot:run
