#Documentação da API Spring Boot
Esta é uma API RESTful simples criada com Spring Boot, Spring MVC e MySQL.

Configuração do ambiente
Antes de usar a API, você precisará ter o seguinte ambiente configurado:

JDK 1.8 ou superior
Maven
MySQL
Configuração do banco de dados
Abra o MySQL Workbench ou qualquer outra ferramenta de gerenciamento de banco de dados MySQL.
Crie um novo schema chamado "test".
Execute o seguinte script SQL para criar a tabela "user":

```
```sql
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
```

Insira alguns dados na tabela "user" usando o seguinte script SQL:

```sql
INSERT INTO `user` (`name`, `email`) VALUES
('John Doe', 'johndoe@example.com'),
('Jane Doe', 'janedoe@example.com');
```

Clonando o projeto
Abra o terminal ou prompt de comando.
Navegue até o diretório onde deseja clonar o projeto.
Execute o seguinte comando:

git clone https://github.com/lucasnunesdev/cadastro-usuarios.git

Executando a aplicação
Abra o terminal ou prompt de comando.
Navegue até o diretório do projeto clonado.
Execute o seguinte comando:

mvn spring-boot:run

Usando a API
A API possui os seguintes endpoints:

Endpoint	Método HTTP	Descrição
/users	GET	Retorna todos os usuários.
/users/{id}	GET	Retorna um usuário pelo ID.
/users	POST	Cria um novo usuário.
/users/{id}	PUT	Atualiza um usuário existente pelo ID.
/users/{id}	DELETE	Exclui um usuário existente pelo ID.
Exemplos de uso
GET /users
Retorna todos os usuários cadastrados.

curl http://localhost:8080/users

Resposta

[
  {
    "id": 1,
    "name": "John Doe",
    "email": "johndoe@example.com"
  },
  {
    "id": 2,
    "name": "Jane Doe",
    "email": "janedoe@example.com"
  }
]

GET /users/{id}
Retorna um usuário pelo ID.

curl http://localhost:8080/users/1

Resposta

{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@example.com"
}

POST /users
Cria um novo usuário.

curl -X POST -H "Content-Type: application/json" -d '{"name":"Bob Smith","email":"bobsmith@example.com"}' http://localhost:8080/users

Resposta:

{
  "id": 3,
  "name": "Bob Smith",
  "email": "bobsmith@example.com"
}
