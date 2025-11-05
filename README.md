# API de Gerenciamento de Frotas (Localiza Backend)

Este é o repositório do backend para a aplicação de gerenciamento de frotas (similar ao "Localiza"). 
É uma API RESTful completa construída com Spring Boot, Spring Security e JPA, projetada para ser consumida pelo Angular.

## Funcionalidades Principais

* **Autenticação e Autorização:** Sistema de login completo usando Spring Security com tokens JWT.
* **Controle de Acesso Baseado em Role:** Endpoints protegidos por `@PreAuthorize`, diferenciando usuários `ADMIN` de `USER`.
* **CRUD Completo:** Operações de Criar, Ler, Atualizar e Deletar para Carros, Marcas e Acessórios.
* **Busca:** Endpoints de busca parcial (LIKE %...%) para encontrar itens "digitando".
* **Paginação:** Endpoint de `findAll` para Acessórios (`/api/acessory/findAll/...`) com paginação completa.
* **Soft Delete:** Os carros não são deletados do banco; eles são desativados usando um `carStatus` (exclusão lógica).
* **Gerenciamento de Relacionamentos:** Lógica para vincular e desvincular Carros com Marcas (`@ManyToOne`) e Acessórios (`@ManyToMany`).
* **Documentação de API:** Configurado com SpringDoc (Swagger) para documentação interativa e testes de endpoint.

## 🛠️ Tecnologias Utilizadas (Backend)

* **Java 17**
* **Spring Boot 3.5.7**
* **Spring Security:** 
* **Spring Data JPA (Hibernate):** 
* **MySQL:** 
* **Maven:** 
* **Lombok:** 
* **SpringDoc OpenAPI (Swagger):**

## Contexto para o Frontend (Angular)

Este backend foi projetado para se integrar com o Angular 

* **Consumo da API:** O frontend utiliza `HttpClient` do Angular para fazer requisições.
* **Autenticação:** O frontend armazena o token JWT recebido do `/api/login` no `localStorage`.
* **Interceptor HTTP:** Um `HttpInterceptorFn` é usado para anexar automaticamente o token (`Authorization: Bearer ...`) a todas as requisições, exceto para a tela de login.
* **Guarda de Rotas:** O frontend usa `CanActivateFn` (Guards) para verificar se o usuário tem a `role` necessária (`hasRole('ADMIN')`) antes de permitir o acesso a rotas protegidas (como `/admin/**`).
* **Modais:** O frontend utiliza um padrão de "Modal sobre Lista", onde as listas (`carslist`, `brandslist`) abrem os componentes de "detalhes" (`carsdetails`, `brandsdetails`) dentro de um modal MDBootstrap para criar ou editar registros.
* **CORS:** O backend está configurado com `@CrossOrigin("*")`, permitindo requisições de qualquer origem (ideal para desenvolvimento com `localhost:4200`).

##  Infos para rodar


    ```properties
    # Configuração do Banco de Dados
    spring.datasource.url=jdbc:mysql://localhost:3306/localiza
    spring.datasource.username=seu-usuario-mysql
    spring.datasource.password=sua-senha-mysql
    spring.jpa.hibernate.ddl-auto=update

    # Configuração do JWT (use uma chave longa e aleatória)
    jwt.secret=CHAVE_SECRETA_LONGA_E_ALEATORIA_PARA_GERAR_TOKENS_JWT
    jwt.expiration-hours=1
    
    ```

  **Comando caso for rodar por terminal:**

    ```
    mvn spring-boot:run
    ```

## Documentação da API (Swagger)

**`http://localhost:8080/swagger-ui/index.html`**
