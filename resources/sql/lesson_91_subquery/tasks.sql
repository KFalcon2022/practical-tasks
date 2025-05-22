-- Задача 1
-- Найти всех пассажиров, чье имя и фамилия содержат хотя бы одну букву "a",
-- и у которых дата рождения меньше 1990 года.
-- Эту задачу можно решить и без подзапроса.
-- Поэтому предлагаю продумать хотя бы два возможных варианта решения.
select * from passenger
where id in (
    select id from passenger
    where (first_name ilike '%a%' or last_name ilike '%a%') and birth_date < '1990-01-01'
);

-- Задача 2
-- Найти топ-3 аэропорта, которые являются самыми популярными среди пассажиров
-- (с наибольшим количеством упоминаний в столбце favorite_airports).
-- Для получения набора единичных элементов из массива существует агрегатная функция unnest().
select count(*) count, airport_name from (
	select unnest(favorite_airports) airport_name from passenger
) a
group by airport_name
order by count desc
limit 3;

-- Задача 3*
-- Найти количество мужчин и женщин среди пассажиров.
-- Пример вывода:

-- Male     |     Female
-- ----------------------
--    5     |       7
select
(select count(*) from passenger p where male group by male) male,
(select count(*) from passenger p where not male group by male) female;
-- Решить эту задачу можно и иными, более элегантными способами.
-- В данном случае - задача лишь на понимание "выражений" для SELECT-блока