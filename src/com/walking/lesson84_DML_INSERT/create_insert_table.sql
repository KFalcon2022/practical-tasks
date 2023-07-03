create table passenger
(
    id                bigserial,
    first_name        varchar(100),
    last_name         varchar(100),
    birth_date        date,
    male              boolean,
    last_purchase     timestamp,
    favorite_airports text[]
);

insert into passenger (first_name, last_name, birth_date, last_purchase, favorite_airports)
values ('Jack', 'Daniels', '01-10-1966', null, null),
       ('John', 'Doe', '02-15-1983', null, null),
       ('Red', 'Label', '04-23-1975', null, null),
       ('Johny', 'Mahony', '07-07-1965', null, null),
       ('Stanly', 'Ibkis', '06-14-1971', null, null),
       ('Axel', 'Foley', '12-13-1979', null, null),
       ('Shon', 'Jameson', '09-09-1991', null, null),
       ('John', 'Rambo', '11-22-1951', null, null),
       ('James', 'Bond', '12-31-1962', null, null),
       ('John', 'Reed', '04-21-1974', null, null)

    insert into passenger (first_name, last_name, birth_date, male, last_purchase, favorite_airports)
values ('Дмитрий', 'Панамарёв', '03-17-1969', true, now(), '{"Ростов"}'),
    ('Полина', 'Панамарёва', '04-21-1968', false, now(), '{"Ростов"}'),
    ('Андрей', 'Панамарёв', '05-28-1991', true, now(), '{"Ростов"}'),
    ('Светлана', 'Панамарёва', '05-28-1996', false, now(), '{"Ростов"}');
