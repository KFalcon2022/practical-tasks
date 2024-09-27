
select count(*), first_name from passenger group by first_name;

select count(*), first_name from passenger group by first_name having count(*) > 1;

select first_name from passenger group by first_name having count(*) > 1;

select count(*), male from passenger where last_purchase
    is not null group by male having count(*)> 1 order by male limit 1 offset 0;

/*Получите число пассажиров по длине имени.
  Нас интересуют только короткие имена (меньше 6 символов).
  Если пассажиров с заданной длиной имени меньше, чем два – игнорируйте их в результирующей выборке.
  Отсортируйте данные по количеству пассажиров.*/

  select count(*), first_name from passenger group by first_name;