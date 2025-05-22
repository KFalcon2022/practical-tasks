-- Задача 1
-- Получите всех пассажиров, у которых имя начинается с буквы «I».
select * from passenger where first_name like 'I%';

-- Задача 2
-- Получите всех пассажиров, у которых имя содержит букву «I» (в любом регистре).
select * from passenger where first_name ilike '%i%';

-- Задача 3
-- Получите всех пассажиров, у которых первым из любимых аэропортов является Minsk, Moscow или Tallinn.
select * from passenger where favorite_airports[1] in ('Minsk', 'Moscow', 'Tallinn');

-- Задача 4
-- Найдите всех пассажиров, родившихся в XX веке.
select * from passenger where birth_date between '1901-01-01' and '2000-12-31';

-- Задача 5
-- Найдите всех пассажиров, родившихся не в XX веке.
select * from passenger where birth_date not between '1901-01-01' and '2000-12-31';

-- Задача 6
-- Найдите всех пассажиров, которые застали Вторую мировую войну (1 сентября 1939 – 2 сентября 1945).
select * from passenger where birth_date <= '1945-09-02';
-- Да, не особо удачная задача получилась. Хотелось на OVERLAPS