 ## Biblioteca-api 
 
 > TESTE PARA VAGA DE DESENVOLVEDOR BACK-END JÚNIOR 🧑🏽‍💻
 ## Tecnologias Utilizadas

+ Java
+ Spring Boot
+ Maven
+ Spring Data JPA
+ Spring Web
+ MySQL
+ Intellij IDEA

## Configurações Necessárias
> Ter instalado em sua máquina:
  
+ JDK (Java Development Kit)
+ Maven
+ Ter um servidor MySQL executando o banco de dados da API.
+ Atualize as configurações de acesso ao banco no arquivo (src/main/resources/application.properties).

## Chamadas dos Serviços (Exemplos)
+ Adicionar Livro:
> POST:  /livros/save

  Body: {
  "titulo": "O Senhor dos Anéis",
  "autor": "J.R.R. Tolkien",
  "quantidade": "10"
}


+ Editar Livro:
> PUT:  /livros/edit/{id}

Body: {
        "titulo": "Harry Potter",
        "autor": "J. K. Rowling"
    }
    

+ Excluir Livro:
> DELETE:  /livros/delete/{id}


+ Realizar Empréstimo:
> POST:  /emprestimo/save

Body: {
   "livro": 1,
  "usuario": 2
}



+ Realizar Devolução:
> DELETE:   emprestimo/delete/{id}


+ Adicionar Usuário:
 > POST:   /usuarios/save

Body: {
  "nome": "Pedro"
}

+ Editar Usuário:
> PUT:  usuarios/edit/{id}

Body:  {
    "nome": "João"
    }

+ Excluir Usuário:
> DELETE:   usuarios/delete/{id}
