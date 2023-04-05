# Our_Library
Aplicacao desenvolvida com Spring Boot, ultilizando o banco de dados Postgresql, Spring Data Jpa, Lombok, Spring web e Spring Security.   
Muito top, essa é a parte do Back-end.

POST's
-Criar o estudante
{
    "period_course": "6",
    "cpf":"05069314041",
    "name_user":"Emanuel",
    "enumGender":"MASCULINE",
    "adress":{
        "road": "Sitio cosme de brito",
        "number": "6350",
        "city":"Bernardino Batista",
        "uf":"PB",
        "neighborhood":"Cosme de Brito"
    },
    "contactList": [
        {
        "gmail" : "hiwdo4645@dogemn.com",
        "telephone":"83996998014"
        }
    ],
    "login":{
        "registration": "73713652",
        "password":".bhvbhb hh"
    },
    "course": {
        "area": "HUMAN",
        "name_Course": "História"
    }
}

-Criar o book
{
    "name":"História",
    "isbn":"6526525-8",
    "area":"HUMAN",
    "isAvailable":true
}

-Criar o Bibliotecario
{
    "period_course": "6",
    "cpf":"94275845056",
    "name_user":"Emanuel",
    "enumGender":"MASCULINE",
    "adress":{
        "road": "Sitio cosme de brito",
        "number": "6350",
        "city":"Bernardino Batista",
        "uf":"PB",
        "neighborhood":"Cosme de Brito"
    },
    "contactList": [
        {
        "gmail" : "hiwdo4645@dogemn.com",
        "telephone":"83996998014"
        }
    ],
    "login":{
        "registration": "73713652",
        "password":".bhvbhb hh"
    }
}

-Criar a biblioteca
{
    "library_name":"Biblioteca fafic",
    "institution_name":"Faculdade ",


 }
 
-Adicionar os campos correpondentes a Biblioteca ja criada
{
    "id":1,
    "library_name":"Biblioteca fafic",
    "institution_name":"Faculdade ",
    "students":[{
        "id":1
    }],
    "librarian":{
        "id":2
    },
    "books":[{
        "isbn":"6526525-8"
    }]

 }
 -Criar o emprestimo
{
    "loanDate":"2023-04-03",
    "book":{
        "isbn": "6526525-8"
    },
    "student":{
        "id":1
    }

}

-Creiar devolucao

{
    "loan":{
        "id":1
    }
}

