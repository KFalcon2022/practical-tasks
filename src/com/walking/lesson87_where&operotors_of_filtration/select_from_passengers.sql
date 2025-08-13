
/*Задача 1*/
select * from passenger where first_name like 'I%';

/*Задача 2*/
select * from passenger where first_name ilike '%i%';

/*Задача 3*/
select * from passenger where favorite_airports[1] in ('Minsk', 'Moscow', 'Tallinn');

/*Задача 4*/
select * from passenger where birth_date between '01-01-1901' and '12-31-2000';

/*Задача 5*/
select * from passenger where birth_date not between '01-01-1901' and '12-31-2000';

/*Задача 7*/
select * from passenger where (birth_date, birth_date + 85) overlaps ('09-01-1939'::date, '09-01-1945'::date);