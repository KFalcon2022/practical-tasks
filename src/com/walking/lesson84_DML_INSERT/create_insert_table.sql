
create table passenger
(
    id                bigserial primary key ,
    first_name        varchar(100),
    last_name         varchar(100),
    birth_date        date,
    male              boolean default true,
    last_purchase     timestamp,
    favorite_airports text[]
);

insert into passenger (first_name, last_name, birth_date, last_purchase, favorite_airports)
values ('Ivan', 'Petrov', '01-10-1966', null, null),
       ('Vasilii', 'Sidorov', '02-15-1983', null, null),
       ('Dmitrii', 'Abramov', '04-23-1975', null, null),
       ('Denis', 'Varnavskiy', '07-07-1965', null, null),
       ('Sergey', 'Kozlov', '06-14-1971', null, null),
       ('Ivan', 'Kharitonov', '12-13-1979', null, null),
       ('Stanislav', 'Pavlenko', '09-09-1991', null, null),
       ('Boris', 'Sokolov', '11-22-1951', null, null),
       ('Nikolai', 'Logunov', '12-31-1962', null, null),
       ('Alexander', 'Konyahin', '04-21-1974', null, null);

    insert into passenger (first_name, last_name, birth_date, male, last_purchase, favorite_airports)
values ('Дмитрий', 'Панамарёв', '03-17-1969', true, now(), '{"Ростов"}'),
    ('Полина', 'Панамарёва', '04-21-1968', false, now(), '{"Ростов"}'),
    ('Андрей', 'Панамарёв', '05-28-1991', true, now(), '{"Ростов"}'),
    ('Светлана', 'Панамарёва', '05-28-1996', false, now(), '{"Ростов"}');

insert into passenger (first_name, last_name, birth_date, male, last_purchase, favorite_airports)
values ('Ivan', 'Susanin', '01-01-1613', true, null, null),
       ('Ivan', 'Popov', '07-30-1975', true, '05-15-2023', '{"Minsk", "Moscow"}'),
       ('Igor', 'Abramov', '06-07-1986', true, '02-16-2023', '{"Moscow", "Sochi"}'),
       ('Irina', 'Volkova', '03-18-1989', false, '07-15-2023', '{"Tallinn", "Magadan"}');
