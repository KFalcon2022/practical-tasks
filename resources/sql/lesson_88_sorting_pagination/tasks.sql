-- Задача 1
-- Получите записи по всем совершеннолетним пассажирам. Отсортируйте их по имени.
select * from passenger
where birth_date <= now() - make_interval(18)
order by first_name;

-- Задача 2
-- Получите только вторую и третью записи из предыдущего запроса.
select * from passenger
where birth_date <= now() - make_interval(18)
order by first_name, id
offset 1 limit 2;