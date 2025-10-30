<img width="1566" height="673" alt="mer" src="https://github.com/user-attachments/assets/9df1ad81-5c43-45ea-b218-86fb13eb55e2" />


# 💸 Finora - Financial Management API

Finora é um sistema de gestão financeira desenvolvido em **Java Spring Boot**, com persistência no **Oracle Database**, seguindo arquitetura em camadas (Model, Repository, Service e Controller).  
Este backend fornece uma API RESTful completa para controle de **usuários, categorias, metas, locais, transações e recorrências**.

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Oracle Database**
- **Hibernate**
- **Maven**
- **Postman** (para testes)

---

## ⚙️ Configuração do Projeto

### Banco de Dados
- **SGBD:** Oracle 11g (FIAP Instance)
- Atualize o arquivo `application.properties` com suas credenciais Oracle:

#### Opção 1: Usando variáveis de ambiente do Windows PowerShell
##### Execute estes comandos antes de iniciar a aplicação:
```ps
$env:ORACLE_DB_USERNAME="SEU_USUARIO"
$env:ORACLE_DB_PASSWORD="SUA_SENHA"
$env:ORACLE_DB_HOST="oracle.fiap.com.br"
$env:ORACLE_DB_PORT="1521"
$env:ORACLE_DB_SID="ORCL"
```

##### Utilize no `application.properties`:
```properties
spring.datasource.url=jdbc:oracle:thin:@//${ORACLE_DB_HOST}:${ORACLE_DB_PORT}/${ORACLE_DB_SID}
spring.datasource.username=${ORACLE_DB_USERNAME}
spring.datasource.password=${ORACLE_DB_PASSWORD}
```

#### Opção 2: Configuração direta
```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

### Inicialização
```bash
mvn spring-boot:run
```
O servidor será iniciado em: `http://localhost:8080`

---

## 🧩 Endpoints Disponíveis

### 👤 **Usuário (`/api/users`)**
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| POST | `/register` | Cria um novo usuário. |
| POST | `/authenticate` | Autentica o usuário e atualiza o último login. |
| PUT | `/` | Atualiza os dados de um usuário existente. |
| PUT | `/preferences/{userId}` | Atualiza as preferências de um usuário. |
| DELETE | `/{id}` | Remove um usuário. |

**Exemplo JSON:**
```json
{
  "name": "lucas",
  "email": "lucas@email.com",
  "plainPassword": "123456"
}
```

---

### 🗂️ **Categoria (`/api/categories`)**
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/user/{userId}` | Lista todas as categorias de um usuário. |
| POST | `/` | Cria uma nova categoria. |
| PUT | `/{id}` | Atualiza uma categoria existente. |
| DELETE | `/{id}` | Remove uma categoria e suas dependências. |

**Exemplo JSON:**
```json
{
  "name": "Investimentos",
  "type": "EDUCATION",
  "colorHex": "#FF5733",
  "isDefault": false
}
```

---

### 🎯 **Metas (`/api/goals`)**
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/user/{userId}` | Lista todas as metas do usuário. |
| POST | `/` | Cria uma nova meta financeira. |
| PUT | `/{id}` | Atualiza apenas os campos informados da meta. |
| DELETE | `/{id}` | Remove uma meta. |

**Exemplo JSON:**
```json
{
  "user": { "id": 1 },
  "category": { "id": 2 },
  "title": "Viagem para Europa",
  "description": "Economizar para férias",
  "targetValue": 10000,
  "currentValue": 2500,
  "startDate": "2025-01-01T00:00:00",
  "endDate": "2025-12-31T00:00:00",
  "goalType": "G"
  "notificationConfig": "{\"notifyOnProgress\":true}"
}
```

---

### 📍 **Locais (`/api/locals`)**
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/user/{userId}` | Lista todos os locais do usuário. |
| POST | `/` | Cadastra um novo local. |
| PUT | `/{id}` | Atualiza um local existente. |
| DELETE | `/{id}` | Remove um local. |

**Exemplo JSON:**
```json
{
  "name": "Supermercado Central",
  "type": "F",
  "address": "Av. Paulista, 1000",
  "coordinates": "-23.563210, -46.654321"
}
```

---

### 🔁 **Recorrências (`/api/recurrences`)**
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/user/{userId}` | Lista todas as recorrências de um usuário. |
| POST | `/` | Cria uma nova recorrência. |
| PUT | `/{id}` | Atualiza uma recorrência existente. |
| DELETE | `/{id}` | Remove uma recorrência. |

**Exemplo JSON:**
```json
{
  "title": "Aluguel do Apartamento 2",
  "description": "Pagamento mensal do aluguel",
  "value": 2500.00,
  "type": "RENT",
  "frequency": "M",
  "refDate": "2025-10-01",
  "totalOccurrences": 12,
  "remainingOccurrences": 11
}
```

---

### 💰 **Transações (`/api/transactions`)**
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/user/{userId}` | Lista as transações de um usuário. |
| POST | `/` | Cria uma nova transação. |
| PUT | `/{id}` | Atualiza uma transação existente. |
| DELETE | `/{id}` | Remove uma transação. |

**Exemplo JSON:**
```json
{
  "value": 200.50,
  "date": "2025-10-27T15:00:00",
  "description": "Compra no supermercado",
  "type": "E",
  "installment": 1,
  "totalInstallments": 1,
  "isRecurring": false
}
```

---


### 📅 **Resumo Mensal (`/api/mensal-resumes`)**
**Em desenvolvimento.**
| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/` | Retorna todos os resumos mensais. |
| GET | `/{id}` | Busca um resumo mensal pelo ID. |
| POST | `/` | Cria um novo resumo mensal. |
| PUT | `/{id}` | Atualiza um resumo existente. |
| DELETE | `/{id}` | Remove um resumo. |

**Exemplo JSON:**
```json
{
  "refMonth": "2025-10",
  "totalEntry": 5000,
  "totalExit": 3200
}
```

---

## ⚠️ Tratamento de Erros (HTTP)

| Código | Descrição |
|--------|------------|
| `400` | Erro de validação ou JSON malformado |
| `401` | Falha de autenticação |
| `404` | Recurso não encontrado |
| `409` | Violação de integridade (FK/Unique) |
| `500` | Erro interno do servidor |

---