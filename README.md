# Crédito Manager API

Este é um projeto de API REST desenvolvida em Spring Boot para gerenciamento de créditos de ISSQN.

## 📦 Tecnologias Utilizadas

- Java 21 LTS
- Spring Boot
- Spring Data JPA
- PostgreSQL 17 (Docker)
- Apache Kafka
- Docker (opcional)
- JUnit & Mockito
- Swagger (OpenAPI) - <http://localhost:8080/swagger-ui/index.html>

## 🚀 Como Executar

### Com Docker

1. Crie a imagem e suba os containers:
   ```bash
   docker-compose -f docker-compose.yml up
   ```

Ou se preferir:

```
docker compose up --build
```

1. Acesse a aplicação:
    - API: `http://localhost:8080`

2. Lembre-se de executar o script init.sql em seu banco de dados (apenas os inserts) e executando o docker-compose não será necessário.

### Sem Docker

1. Configure o banco PostgreSQL.
2. Inicie o Apache Kafka localmente (porta padrão `9092`).
3. Configure o `application.properties` de acordo com o seu ambiente (se for rodar sem o Docker).
4. Execute a aplicação:

   ```bash
   ./mvnw spring-boot:run
   ```

Ou

   ```bash
   mvn spring-boot:run
   ```

## ✉️ Kafka

A aplicação envia logs de consulta para o tópico Kafka `consulta-log` através do serviço `KafkaProducerService`.

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

## 🔒 CORS

O projeto possui configuração separada para permitir CORS em ambientes front-end.

## 📌 Extras

- Mensageria com Kafka a cada consulta.
- Testes automatizados com cobertura de serviços.
