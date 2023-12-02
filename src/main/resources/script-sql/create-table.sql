
create table users (
    usu_id bigint not null,
    usu_email varchar(100),
    usu_name varchar(100) not null,
    usu_password varchar(200) not null,
    primary key (usu_id)
);

create sequence s_usuario start with 1 increment by 1;

insert into public.users values( 1 ,'admin','admin','admin','$2a$10$lI1zzAi8XdDV7C4x0z9kc.CiWMGX3UkAe7vhmYPqZ//kt2K6bSzB.');