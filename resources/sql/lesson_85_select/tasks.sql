-- Задача 1
-- Получите список имен, фамилий и дат рождений всех пассажиров.
select first_name, last_name, birth_date from passenger;

-- Задача 2
-- Получите список любимых аэропортов по каждому пассажиру.
select id, favorite_airports from passenger;

-- Задача 3
-- Получите первый из любимых аэропортов по каждому пассажиру.
-- Массивы в SQL нумеруются с 1.
-- Синтаксис для получения элементов массива не отличается от Java
select id, favorite_airports[1] from passenger;