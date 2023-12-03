create table users (
    usu_id integer not null,
    usu_email varchar(100) not null,
    usu_login varchar(20) not null,
    usu_name varchar(100) not null,
    usu_password varchar(200),
    primary key (usu_id));

alter table users drop constraint UK_qfpm1fxdsr7178jkpqj6yusm5;

alter table users add constraint UK_qfpm1fxdsr7178jkpqj6yusm5 unique (usu_login);

create sequence s_usuario start with 1 increment by 1;

insert into public.users values( 1 ,'admin@gmail.com','admin','Administrador do Sistema','$2a$10$lI1zzAi8XdDV7C4x0z9kc.CiWMGX3UkAe7vhmYPqZ//kt2K6bSzB.');
