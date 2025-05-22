-- Задача 1
-- Верните все имена и фамилии из таблиц passenger_female, passenger_male и passenger.
-- Исключите дубликаты (не только возникающие при объединении выборок).
select distinct first_name, last_name from (
    select first_name, last_name from passenger
    union
    select first_name, last_name from passenger_male
    union
    select first_name, last_name from passenger_female
);

-- Задача 2
-- Получите всю информацию о первых трех самых старых пассажиров,
-- имеющих хотя бы один любимый аэропорт,
-- из объединенных таблиц passenger_female, passenger_male.
select * from (
    select * from passenger_male
    where cardinality(favorite_airports) > 0
    order by birth_date desc limit 3
    union
    select * from passenger_female
    where cardinality(favorite_airports) > 0
    order by birth_date desc limit 3
) p
order by birth_date desc limit 3;