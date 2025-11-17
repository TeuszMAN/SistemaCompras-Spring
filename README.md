# Sistema de Compras - Spring Boot API 🛒

Uma API REST desenvolvida com Spring Boot para gerenciamento de pedidos de compras, implementando padrões de design como **Factory**, **Strategy** e **Adapter**.

## 🎯 Funcionalidades

- ✅ Criação e consulta de pedidos
- ✅ Processamento de pedidos (COMUM ou EXPRESSO)
- ✅ Gerenciamento de produtos e itens
- ✅ Sistema de logística integrado
- ✅ Banco de dados H2 in-memory
- ✅ Persistência JPA/Hibernate

## 🏗️ Arquitetura

### Padrões de Design Implementados

#### 🏭 **Factory Pattern**
- **`PedidoFactory`**: Cria instâncias de processamento de pedidos baseado no tipo (COMUM/EXPRESSO)

#### 🎯 **Strategy Pattern**
- **`IPedido`**: Interface para diferentes estratégias de processamento
- **`PedidoComum`**: Aplica desconto global do sistema
- **`PedidoExpresso`**: Aplica taxa de urgência, sem desconto

#### 🔌 **Adapter Pattern**
- **`LogisticaAdapter`**: Adapta o sistema moderno para integrar com serviços legados de logística

### Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/projetosoftwareteusz/teusz/
│   │   ├── controller/           # Controllers REST
│   │   ├── service/              # Lógica de negócio
│   │   ├── repository/           # Acesso a dados (JPA)
│   │   ├── entities/             # Entidades JPA
│   │   ├── dto/                  # Data Transfer Objects
│   │   ├── factory/              # Factory Pattern
│   │   ├── pedido/               # Strategy Pattern
│   │   ├── Logistica/            # Adapter Pattern
│   │   └── config/               # Configurações
│   └── resources/
│       └── application.properties
└── test/
```

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Maven**
- **Docker** (opcional)

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Maven 3.6+

### Executando Localmente

1. **Clone o repositório:**
```bash
git clone https://github.com/TeuszMAN/SistemaCompras-Spring.git
cd teusz
```

2. **Execute com Maven:**
```bash
./mvnw spring-boot:run
```

3. **Ou compile e execute:**
```bash
./mvnw clean package
java -jar target/teusz-0.0.1-SNAPSHOT.jar
```

### Executando com Docker

1. **Build da imagem:**
```bash
docker build -t teusz-app .
```

2. **Execute o container:**
```bash
docker run -p 8080:8080 teusz-app
```

## 📡 Endpoints da API

### 📋 Pedidos

#### Criar Pedido
```http
POST /pedidos
Content-Type: application/json

{
  "tipo": "COMUM",
  "itens": [
    {
      "produto": {
        "nome": "Notebook Dell",
        "preco": 2500.00
      },
      "quantidade": 1
    },
    {
      "produto": {
        "nome": "Mouse Wireless",
        "preco": 85.50
      },
      "quantidade": 2
    }
  ]
}
```

**Resposta:**
```json
{
  "id": 1,
  "dataCriacao": "2025-11-17T12:30:45.123+00:00",
  "status": "PRONTO",
  "itens": [
    {
      "id": 1,
      "produto": {
        "id": 1,
        "nome": "Notebook Dell",
        "preco": 2500.00
      },
      "quantidade": 1
    }
  ]
}
```

#### Consultar Pedido
```http
GET /pedidos/{id}
```

### 🎭 Tipos de Pedido

- **`COMUM`**: Aplica desconto global do sistema
- **`EXPRESSO`**: Sem desconto, aplicação de taxa de urgência

### 📊 Status do Pedido

- `NOVO` → `EM_PROCESSAMENTO` → `PRONTO` → `ENTREGUE`

## 🗃️ Banco de Dados

### H2 Console

Acesse: **http://localhost:8080/h2-console**

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

### Entidades

- **`Pedido`**: Pedido principal com data, status e itens
- **`ItemPedido`**: Item individual do pedido
- **`Produto`**: Produto com nome e preço
- **`StatusPedido`**: Enum com estados do pedido
- **`TipoPedido`**: Enum com tipos (COMUM/EXPRESSO)

## 🧪 Testes

```bash
./mvnw test
```

## 📝 Configurações

### application.properties

```properties
# Aplicação
spring.application.name=teusz

# Banco H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.h2.console.enabled=true

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update

# Docker Compose (desabilitado)
spring.docker.compose.enabled=false
```

## 🎯 Exemplos de Uso

### Criando Pedido Comum
```bash
curl -X POST http://localhost:8080/pedidos \
  -H "Content-Type: application/json" \
  -d '{
    "tipo": "COMUM",
    "itens": [
      {
        "produto": {
          "nome": "Smartphone",
          "preco": 1200.00
        },
        "quantidade": 1
      }
    ]
  }'
```

### Criando Pedido Expresso
```bash
curl -X POST http://localhost:8080/pedidos \
  -H "Content-Type: application/json" \
  -d '{
    "tipo": "EXPRESSO",
    "itens": [
      {
        "produto": {
          "nome": "Carregador USB-C",
          "preco": 45.90
        },
        "quantidade": 2
      }
    ]
  }'
```

### Consultando Pedido
```bash
curl http://localhost:8080/pedidos/1
```

## 🏗️ Fluxo de Processamento

1. **Recebimento**: API recebe requisição POST
2. **Validação**: Verifica tipo de pedido obrigatório
3. **Persistência**: Salva pedido e produtos (cascade)
4. **Processamento**: Factory cria strategy baseada no tipo
5. **Estratégia**: Aplica regras específicas (desconto/urgência)
6. **Logística**: Adapter integra com serviço legado
7. **Finalização**: Atualiza status para PRONTO

## 👥 Contribuindo

1. Fork o projeto
2. Crie sua feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para detalhes.

## 👨‍💻 Autor

**Mateus Alves** - [TeuszMAN](https://github.com/TeuszMAN)

---

⭐ **Gostou do projeto? Deixe uma estrela!**