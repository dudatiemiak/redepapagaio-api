# 🌍 RedePapagaio – Plataforma Solidária para Situações Extremas

A **RedePapagaio** é uma aplicação desenvolvida para facilitar a comunicação, mobilização e o apoio mútuo entre cidadãos, voluntários e organizações em **situações de desastres naturais e emergências sociais**. Inspirado no comportamento colaborativo dos papagaios-cinzentos, o sistema promove solidariedade em momentos críticos, conectando quem precisa com quem pode ajudar.

Este projeto foi desenvolvido como parte do desafio **Global Solution 2025-1 da FIAP**, unindo tecnologias modernas como Java Spring Boot, JWT, Swagger, JPA, MapStruct, React Native e integração com IoT/Node-RED.

## 🧰 Tecnologias Utilizadas

- **Backend:** Java 21, Spring Boot 3.2.5, Spring Security, Spring Data JPA, JWT, Swagger OpenAPI 2.8.6, MapStruct
- **Banco de dados:** MySQL 8
- **Autenticação:** JWT com controle de sessão Stateless
- **Documentação:** Swagger (OpenAPI)

## ✅ Funcionalidades Implementadas

- Autenticação segura via JWT
- Cadastro e login de usuários do sistema (usuários de segurança e voluntários)
- Registro de ocorrências com classificação por tipo (enum)
- Criação e listagem de tipos de ocorrências e tipos de ajuda
- Associação de usuários a ajudas realizadas
- Integração com Swagger UI para documentação e testes

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**
```bash
git clone https://github.com/seuusuario/redepapagaio.git
cd redepapagaio
```

2. **Configure o banco de dados MySQL:**
Crie um banco chamado `redepapagaio` e atualize o `application.properties` com suas credenciais.

3. **Execute o projeto:**
```bash
mvn clean install
mvn spring-boot:run
```

4. **Acesse a aplicação no navegador:**
- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## 🔐 Autenticação com JWT

Para acessar as rotas protegidas da API:

1. Acesse `/autenticacao/login`
2. Envie um `POST` com parâmetros `username` e `password` -> que é o email do usuário e a senha
3. Copie o token retornado
4. Clique em **Authorize** no Swagger e informe: `<seu_token>`

---

## 👨‍💻 Integrantes do Grupo

| Nome                                      | RM       | Turma  |
|-------------------------------------------|----------|--------|
| Eduarda Tiemi Akamini Machado             | 554756   | 2TDSPH |
| Felipe Pizzinato Bigatto                  | 555141   | 2TDSPH |
| Gustavo de Oliveira Turci Sandrini        | 557505   | 2TDSPW |


Desenvolvido por alunos da FIAP – Global Solution 2025-1.  
