# MedCloud - Patient Management System

## 📋 Descrição do Projeto
Desenvolvimento de uma aplicação de gerenciamento de pacientes desenvolvida em Spring Boot.

## ✨ Funcionalidades
- Autenticação de usuários com JWT
- Cadastro de pacientes
- Consulta de pacientes por email
- Atualização de informações de pacientes
- Exclusão de pacientes

## 🚀 Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- JPA/Hibernate
- MySQL
- Lombok
- Swagger/OpenAPI

## 📦 Pré-requisitos
- JDK 17
- Maven
- MySQL

## 🔧 Configuração do Projeto

### Clonar o Repositório
```bash
git clone https://github.com/ErickGCA/development-challenge-five.git
cd medcloud
```

### Configuração do Banco de Dados
Crie um banco de dados MySQL:
```sql
CREATE DATABASE medcloud;
```

### Configurar application.properties
```properties
# Configurações do Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/medcloud
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Configurações JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Configurações JWT
jwt.secret=SuaSenhaSecretaAqui
jwt.expiration=3600

# Swagger
springdoc.swagger-ui.path=/swagger-ui.html
```

### Compilar e Executar
```bash
mvn clean install
mvn spring-boot:run
```

## 🔐 Autenticação
A API utiliza autenticação JWT. Para acessar endpoints protegidos:
1. Registre-se em `/api/auth/register`
2. Faça login em `/api/auth/login`
3. Utilize o token retornado no header `Authorization: Bearer <token>`

## 📡 Endpoints Principais
- `POST /api/auth/register`: Registrar novo usuário
- `POST /api/auth/login`: Autenticar usuário
- `POST /api/patients`: Criar paciente
- `GET /api/patients?email=x`: Buscar paciente por email
- `PUT /api/patients/{id}`: Atualizar paciente
- `DELETE /api/patients/{id}`: Excluir paciente

## 📝 Documentação da API
Acesse a documentação interativa do Swagger em:
`http://localhost:8080/swagger-ui.html`


## 👥 Contato
- Nome: [Érick Gonçalves Cabral]
- Email: [erickgcabral@gmail.com]
- LinkedIn: [www.linkedin.com/in/erick-cabralgca]

---

### 🚨 Aviso Importante
- Não compartilhe tokens de autenticação