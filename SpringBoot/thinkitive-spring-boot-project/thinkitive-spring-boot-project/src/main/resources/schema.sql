
create table course
(
    id bigint not null,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key (id)

);

create table users
(
    id bigint not null,
    name varchar(255) not null,
    email varchar(255) not null,
    primary key (id)

);