CREATE TABLE accident
(
    id   serial primary key,
    name varchar(50),
    text varchar(2000),
    address varchar(100),
    type_id int references types(id),
    rule_id int references rules(id)
);