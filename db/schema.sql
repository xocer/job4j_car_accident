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