create table if not exists public.users
(
    id bigserial primary key,
    username   varchar(50),
    password varchar(50),
    enabled   int not null
    );

alter table public.users
    owner to db_user;


create table if not exists public.authorities
(
    id bigserial primary key,
    username   varchar(50) not null ,
    authority   varchar(50) not null
    );

alter table public.authorities
    owner to db_user;

select * from nextval(users_id_seq);

insert into public.users values (nextval('users_id_seq'), 'apektas', '12345', '1');
INSERT INTO public.authorities VALUES (nextval('authorities_id_seq'), 'apektas', 'admin');