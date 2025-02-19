
select count(*) from passenger;

select count(*) from passenger where male = true;

select count(last_purchase) from passenger;

select count(*), male from passenger group by male;

select count(*) from passenger group by male;

select avg(id), count(*), male from passenger group by male;

select count(*), male from passenger where last_purchase
    is not null group by male order by male limit 1 offset 0;

/*Задача Верните в одном запросе: количество совершеннолетних пассажиров,
  наибольшее и наименьшее значение последней покупки. Сделайте группировку по полу */

select count(birth_date >= '07-17-2005'::date),
       min(last_purchase), max(last_purchase) from passenger group by male;