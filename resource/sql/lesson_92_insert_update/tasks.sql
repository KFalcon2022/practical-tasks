create table passenger_male (
  id                   bigserial,
  first_name           varchar(100),
  last_name            varchar(100),
  birth_date           date,
  last_purchase        timestamp,
  favorite_airports    text[],
  created              timestamp      default now()
);

create table passenger_female (
  id                   bigserial,
  first_name           varchar(100),
  last_name            varchar(100),
  birth_date           date,
  last_purchase        timestamp,
  favorite_airports    text[],
  created              timestamp      default now()
);

-- Задача 1
-- Заполните таблицу passenger_female пассажирами-женщинами из таблицы passenger.
insert into passenger_female (first_name, last_name, birth_date, last_purchase, favorite_airports)
select first_name, last_name, birth_date, last_purchase, favorite_airports
from passenger
where not male;

-- Задача 2
-- Обновите все записи в таблице passenger_female,
-- установив им датой создания – 01.01.2023.
update passenger_female set created = '2023-01-01';

-- Задача 3
-- Смените имя всем пассажирам-женщинам с Katerina на Ekaterina.
-- Записи с другим значением имени оставьте без изменений.
update passenger_female set first_name = 'Ekaterina'
where first_name = 'Katerina';