create table types
(
    id   serial primary key,
    name varchar(50)
);

create table rules
(
    id   serial primary key,
    name varchar(50)
);

CREATE TABLE accident
(
    id      serial primary key,
    name    varchar(50),
    text    varchar(2000),
    address varchar(100),
    type_id int references types (id),
    rule_id int references rules (id)
);

insert into rules (name)
values ('Статья. 1');
insert into rules (name)
values ('Статья. 2');
insert into rules (name)
values ('Статья. 3');

insert into types (name)
values ('Две машины');
insert into types (name)
values ('Машина и человек');
insert into types (name)
values ('Машина и велосипед');