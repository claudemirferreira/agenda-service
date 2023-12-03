create table users (
    usu_id integer not null,
    usu_email varchar(100) not null,
    usu_login varchar(20) not null,
    usu_name varchar(100) not null,
    usu_password varchar(200),
    primary key (usu_id));

alter table users drop constraint UK_qfpm1fxdsr7178jkpqj6yusm5;

alter table users add constraint UK_qfpm1fxdsr7178jkpqj6yusm5 unique (usu_login);
