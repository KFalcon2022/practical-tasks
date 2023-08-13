create table passenger (
  id                  bigserial,
  first_name          varchar(100),
  last_name           varchar(100),
  birth_date          date,
  male                boolean         default true,
  last_purchase       timestamp,
  favorite_airports   text[]
);

-- Задача 1
-- Вставьте в таблицу «Пассажиров» 10 мужчин.
-- Их id должен быть задан автоматически.
-- Как новые пассажиры, они не имеют любимых аэропортов и еще не совершали покупок.
insert into passenger (first_name, last_name, birth_date)
values
('Name0', 'Surname0', '1997-12-20'),
('Name1', 'Surname1', '1997-12-20'),
('Name2', 'Surname2', '1997-12-20'),
('Name3', 'Surname3', '1997-12-20'),
('Name4', 'Surname4', '1997-12-20'),
('Name5', 'Surname5', '1997-12-20'),
('Name6', 'Surname6', '1997-12-20'),
('Name7', 'Surname7', '1997-12-20'),
('Name8', 'Surname8', '1997-12-20'),
('Name9', 'Surname9', '1997-12-20');

-- Задача 2
-- Добавьте семью из двух родителей и двух детей.
-- Глава семейства как раз купил билеты на всю семью (вот прям только что, прямо сейчас).
-- Обычно они вылетают из Ростова.
insert into passenger (first_name, last_name, birth_date, male, last_purchase, favorite_airports)
values
('FatherName', 'Surname', '1990-12-20', true, now(), '{"Rostov"}'),
('MotherName', 'Surname', '1991-12-20', false, now(), '{"Rostov"}'),
('SonName', 'Surname', '2000-12-20', true, now(), '{"Rostov"}'),
('DaughterName', 'Surname', '2001-12-20', false, now(), '{"Rostov"}');