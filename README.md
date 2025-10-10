# Gerenciador Financeiro Pessoal

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

## 📝 Descrição

Este é um projeto de portfólio pessoal para um sistema de gerenciamento de transações financeiras. A versão inicial é uma aplicação de console simples, desenvolvida com foco em boas práticas de Programação Orientada a Objetos em Java.

## 🎯 Motivação

Este projeto nasceu do meu interesse em aplicar e aprofundar meus conhecimentos em Java em um problema prático. O objetivo é evoluir esta aplicação gradualmente, usando-a como base para estudar e implementar tecnologias de back-end mais avançadas, como o Spring Boot e bancos de dados SQL.

---

## ✨ Funcionalidades Atuais (Versão Console)

A aplicação atual, executada via terminal, permite ao usuário:

* **Adicionar novas transações:** Registrar entradas do tipo "receita" ou "despesa", especificando um valor e uma descrição.
* **Listar todas as transações:** Exibir um histórico completo de todas as transações adicionadas.
* **Calcular o saldo total:** Apresentar o valor total consolidado, somando as receitas e subtraindo as despesas.
* **Registro por Data:** Cada transação armazena automaticamente a data e a hora exatas de sua criação.

---

## 🚀 Roadmap (Próximos Passos)

O plano de evolução para este projeto inclui as seguintes implementações:

-   [ ] **Migração para Spring Boot:** Refatorar a aplicação para rodar sobre o ecossistema Spring, aproveitando a injeção de dependências e outras facilidades.
-   [ ] **Persistência de Dados com PostgreSQL:** Substituir o armazenamento em memória (`ArrayList`) por um banco de dados PostgreSQL, utilizando Spring Data JPA para o acesso aos dados.
-   [ ] **Construção de uma API REST:** Expor as funcionalidades do sistema através de endpoints RESTful para permitir a integração com diferentes clientes (ex: um front-end web ou mobile).
-   [ ] **Autenticação e Usuários:** Implementar um sistema de cadastro e login de usuários, onde cada usuário possa gerenciar apenas suas próprias transações.

---

## 💻 Tecnologias

#### Versão Atual
* Java
* `ArrayList` para armazenamento em memória
* `java.time` para manipulação de datas

#### Planejadas
* Spring Boot (Spring Web, Spring Data JPA, Spring Security)
* PostgreSQL

## ▶️ Como Executar a Versão Atual

1.  Clone o repositório.
2.  Abra o projeto em sua IDE (ex: IntelliJ IDEA).
3.  Execute o método `main` na classe `Program.java`.
4.  Interaja com o menu que aparecerá no console.

## サンプル Exemplo de Uso (Console)

```
=============== Menu ===============
||                                ||
||  1 - Adicionar nova transação  ||
||  2 - Listar transações         ||
||  3 - Exibir saldo total        ||
||  4 - Sair                      ||
||                                ||
====================================
Escolha ===> 1

Tipo da transação (despesa/receita): receita
Valor: 1500.00
Descrição da receita: Salário

=============== Menu ===============
...
Escolha ===> 2

Tipo: receita
Valor: 1500.0
Descrição: Salário

...
```
