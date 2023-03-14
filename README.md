# Documentação

Esta é uma API RESTful simples criada com Spring Boot, Spring MVC e MySQL, com o objetivo de Criar, Ler, Atualizar e Deletar Usuários.

Configuração do ambiente
Antes de usar a API, você precisará ter o seguinte ambiente configurado:

- JDK 1.8 ou superior
- Maven
- MySQL
- Configuração do banco de dados
- Abra o MySQL Workbench ou qualquer outra ferramenta de gerenciamento de banco de dados MySQL.
- Crie um novo schema chamado "cadastro-usuarios".
- Execute o seguinte script SQL para criar a tabela "user":


```
CREATE TABLE user (
  codigo INT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  data_nascimento DATE NOT NULL,
  foto LONGBLOB
);
```

### Insira alguns dados na tabela "user" usando o seguinte script SQL:

```
INSERT INTO user (codigo, nome, data_nascimento, foto) VALUES (1, 'João', '1990-01-01', NULL);
INSERT INTO user (codigo, nome, data_nascimento, foto) VALUES (2, 'Maria', '1995-03-15', NULL);

```

## Clonando o projeto

- Abra o terminal ou prompt de comando.
- Navegue até o diretório onde deseja clonar o projeto.
- Execute o seguinte comando:

```

git clone https://github.com/lucasnunesdev/cadastro-usuarios.git

````

## Executando a aplicação

- Abra o terminal ou prompt de comando.
- Navegue até o diretório do projeto clonado.
- Execute o seguinte comando:

```

mvn spring-boot:run

```

## Usando a API

A API possui os seguintes endpoints:

| Endpoint     | Método HTTP | Descrição                                |
| --------     | ----------- | ---------------------------------------- |
| /users	     | GET	       | Retorna todos os usuários.               |
| /users/{id}  | GET	       | Retorna um usuário pelo ID.              |
| /users	     | POST	       | Cria um novo usuário.                    |
| /users/{id}  | PUT	       | Atualiza um usuário existente pelo ID.   |
| /users/{id}  | DELETE	     | Exclui um usuário existente pelo ID.     |

## Exemplos de uso

GET /users
Retorna todos os usuários cadastrados.

```
curl http://localhost:8080/users
```

Resposta

```
[
  {
    "id": 1,
    "name": "João",
    "data_nascimento": "1990-01-01"
    "foto": null
  },
  {
    "id": 2,
    "name": "Maria",
    "data_nascimento": "1995-03-15"
    "foto": null
  }
]

```

GET /users/{id}
Retorna um usuário pelo ID.

```
curl http://localhost:8080/users/1
```

Resposta

```
{
   "id": 1,
    "name": "João",
    "data_nascimento": "1990-01-01"
    "foto": null
}
```

POST /users
Cria um novo usuário.

```
curl -X POST -H "Content-Type: application/json" -d '{
    "codigo": 5,
    "nome": "Felipe Amorim",
    "dataNascimento": "1997-01-04",
    "foto": null} http://localhost:8080/users
```

Resposta:
```
{
  "id": 3,
  "name": "Bob Smith",
  "email": "bobsmith@example.com"
}
```

## Tratando o campo de foto

Para inserir uma foto, basta apenas colocar no chave "foto" do json o código em base64 da imagem desejada.
Não é a melhor forma inserir uma imagem diretamente no banco de dados, mas para fins de praticidade esse projeto tratou dessa forma.


