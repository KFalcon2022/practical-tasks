-- Задача 1
-- Получите запись с id равным 1.
select * from passenger where id = 1;

-- Задача 2
-- Получите все записи, для которых нет любимых аэропортов.
select * from passenger where favorite_airports is null or cardinality(favorite_airports) = 0;

-- Задача 3
-- Получите все записи, где фамилия равна «Petrov» и имя равно «Petr».
-- Добавьте к выборке все записи, для которых дата рождения меньше,
-- чем дата последней покупки билета.
select * from passenger where (first_name = 'Petr' and last_name = 'Petrov') or birth_date < last_purchase;