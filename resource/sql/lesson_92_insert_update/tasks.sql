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

-- Задача 2
-- Обновите все записи в таблице passenger_female,
-- установив им датой создания – 01.01.2023.

-- Задача 3
-- Смените имя всем пассажирам-женщинам с Katerina на Ekaterina.
-- Записи с другим значением имени оставьте без изменений.