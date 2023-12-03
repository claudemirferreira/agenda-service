# Passos para rodor a aplicação

## 1 criar o banco de dados que esta configurado no application.properties
```.json
spring.database.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/dbagenda
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.database.default-schema=public

```

## 2 executa o script resources/script-sql/create-table.sql
```.json

create table users (
    usu_id bigint not null,
    usu_email varchar(100),
    usu_name varchar(100) not null,
    usu_password varchar(200) not null,
    primary key (usu_id)
);

create sequence s_usuario start with 1 increment by 1;

insert into public.users values( 1 ,'admin','admin','admin','$2a$10$lI1zzAi8XdDV7C4x0z9kc.CiWMGX3UkAe7vhmYPqZ//kt2K6bSzB.');

```

## 3 mvn clean install

## 4 executar a aplicação

## 5 acessa o swagger no link

```.json
http://localhost:8080/swagger-ui/index.html
``