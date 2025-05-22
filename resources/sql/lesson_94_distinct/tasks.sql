-- Задача 1
-- Верните данные обо всех уникальных датах рождения среди пассажиров мужского пола.
select distinct birth_date from passenger where male;

-- Задача 2
-- Верните информацию по самому молодому носителю каждой фамилии.
select distinct on(last_name) * from passenger order by last_name, birth_date;

-- Задача 3
-- Верните список уникальных имен. Если имя носит и мужчина, и женщина - оно должно быть указано дважды.
select distinct on(first_name, male) first_name from passenger order by first_name, male;