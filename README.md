# API Cadastro Ninja

## 📑 Descrição

API desenvolvida em Java utilizando Spring Boot para gerenciar um cadastro de ninjas. 
Permite operações de CRUD (Criar, Ler, Atualizar e Deletar) sobre os registros de ninjas.

---

## 🛠️ Tecnologias Utilizadas

- ✔️ Java 17+
- ✔️ Spring Boot
- ✔️ Spring Data JPA
- ✔️ Flyway (Controle de versionamento de banco de dados)
- ✔️ Lombok (Redução de boilerplate de código)
- ✔️ H2 Database (Banco de dados em memória)
- ✔️ Maven

---

## 📦 Funcionalidades

- ✅ Cadastro de ninjas / missões
- ✅ Listagem de ninjas / missões
- ✅ Atualização de dados dos ninjas / missões
- ✅ Remoção de ninjas / missões
- ✅ Migração de banco de dados automatizada com Flyway

---

## 🗂️ Endpoints Principais

### 🔹 Ninja Controller

| Método | Endpoint                | Descrição                      |
|--------|--------------------------|---------------------------------|
| GET    | `/ninjas/listar`         | Lista todos os ninjas          |
| GET    | `/ninjas/listar/{id}`    | Lista um ninja por ID          |
| POST   | `/ninjas/criar`          | Cria um novo ninja             |
| PUT    | `/ninjas/alterar/{id}`   | Altera os dados de um ninja    |
| DELETE | `/ninjas/deletar/{id}`   | Deleta um ninja por ID         |

### 🔸 Missões Controller

| Método | Endpoint                   | Descrição                        |
|--------|-----------------------------|-----------------------------------|
| GET    | `/missoes/listar`           | Lista todas as missões           |
| GET    | `/missoes/listar/{id}`      | Lista uma missão por ID          |
| POST   | `/missoes/criar`            | Cria uma nova missão             |
| PUT    | `/missoes/alterar/{id}`     | Altera os dados de uma missão    |
| DELETE | `/missoes/deletar/{id}`     | Deleta uma missão por ID         |

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:
```bash
git clone https://github.com/RafaelGelain/API_CadastroNinja.git
```

2. Acesse a pasta do projeto:
```bash
cd API_CadastroNinja
```

3. Execute o projeto pela sua IDE ou via terminal:
```bash
./mvnw spring-boot:run
```

4. Acesse a aplicação rodando em:
```
http://localhost:8080
```
