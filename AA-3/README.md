# AA3: Aprimoramento do sistema da AA2 criando uma REST API

##  Sistema
Sistema para oferta de vagas de estágios/empregos (A)

##  Arquitetura
Modelo-Visão-Controlador

##  Tecnologias
- Spring MVC, Spring Data JPA, Spring Security & Thymeleaf (Lado Servidor)
- Javascript & CSS (Lado Cliente)

##  Roteiro de execução
Na pasta AA-3, rode o comando a seguir para efetuar o deploy:

```
mvn spring-boot:run
```
Importante lembrar, o tomcat não deve estar rodando localmente, é preciso parar ele para dar certo o deploy, pois o comando acima já roda um tomcat interno.

Server: dsw.cdxlj1ktosxz.sa-east-1.rds.amazonaws.com  
User: admin  
Password: Jycq6wCcDZssF2i  
Pra acessar pelo mysql-client, é necessário rodar o seguinte comando:

```
mysql -h dsw.cdxlj1ktosxz.sa-east-1.rds.amazonaws.com -P 3306 -u admin -p
```

E digitar a senha! :D
# Usuários criados
### Administrador
- id: 1
  - login: admin@gmail.com
  - senha: admin 

### Empresa

- id: 2
  - login: empresa@gmail.com
  - senha: admin 
  
- id: 3
  - login: empresa2@gmail.com
  - senha: admin 


### Profissional
- id: 4
  - login: profissional@gmail.com
  - senha: admin 

- id: 5
  - login: profissional2@gmail.com
  - senha: admin 


# Exemplos de teste

### Profissionais

- GET localhost:8080/profissionais

- POST localhost:8080/profissionais
```
{"nome": "teste", "email": "teste@gmail.com", "papel": "ROLE_PRO", "enabled": true, "telefone": "5511912345678", "sexo": "Masculino", "dataNascimento": "01/01/1981", "senha": "12345678", "cpf": "333.333.333-33"}
```

- GET localhost:8080/profissionais/6

- PUT localhost:8080/profissionais
```
{"nome": "NOVO teste", "email": "NOVOteste@gmail.com", "papel": "ROLE_PRO", "enabled": true, "telefone": "5521987654321", "sexo": "Feminino", "dataNascimento": "31/12/2020", "senha": "87654321", "cpf": "444.444.444-44"}
```

### Empresas

- GET localhost:8080/empresas

- POST localhost:8080/empresas
```
{"nome":"Odebrechht", "email":"odebrechht@gmail.com", "senha": "milmilhoes", "papel":"ROLE_EMPRESA", "enabled":true, "descricao":"Esquema de pirâmide", "cidade":"Brasília","cnpj":"06.144.757/0001-72"}
```

- GET localhost:8080/empresas/7

- PUT localhost:8080/empresas/7
```
{"nome":"Casa de repouso", "email":"nossolar@gmail.com", "senha": "maislavagem", "papel":"ROLE_EMPRESA", "enabled":true, "descricao":"Adivinha só", "cidade":"Cuiabá","cnpj":"17.255.868/0005-83"}
```

### Vagas
- GET localhost:8080/vagas

- GET localhost:8080/vagas/2

- GET localhost:8080/vagas/empresas/2
