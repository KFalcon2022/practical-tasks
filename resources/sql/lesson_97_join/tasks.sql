-- Задача 1
-- Посчитайте число билетов, сгруппировав их по фамилиям пассажиров.
-- Отобразите только те группы, где число билетов больше 3.
select count(*), p.last_name from passenger p
join ticket t on t.passenger_id = p.id
group by p.last_name
having count(*) > 3;

-- Задача 2
-- Найдите наиболее популярный аэропорт прибытия для каждой из фамилий пассажиров.
select distinct on (p.last_name) count(*) count, p.last_name, t.arrival_airport
from passenger p
join ticket t on t.passenger_id = p.id
group by p.last_name, t.arrival_airport
order by p.last_name, count desc;
-- Не единственный возможный, но наиболее очевидный (имхо) на этом этапе вариант решения