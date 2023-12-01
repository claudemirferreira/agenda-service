
create table users (
    usu_id bigint not null,
    usu_email varchar(100),
    usu_name varchar(100) not null,
    usu_password varchar(200) not null,
    primary key (usu_id)
);

create sequence s_usuario start with 1 increment by 1;