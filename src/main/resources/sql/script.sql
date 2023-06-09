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


-- custom sample table structure (above tables are no longer used in the application)
create table if not exists public.customer
(
    id bigserial primary key,
    email   varchar(250) not null ,
    pwd   varchar(250) not null ,
    role   varchar(50) not null
);

alter table public.customer
    owner to db_user;

insert into public.customer values (nextval('customer_id_seq'), 'apektas@sample.com', '54321', 'admin');