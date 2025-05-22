create table ticket (
  id                     bigserial,
  departure_airport      varchar(100),
  arrival_airport        varchar(100),
  departure_date         timestamp,
  arrival_date           timestamp,
  purchase_date          timestamp,
  passenger_id           bigint
);

-- Задача 1
-- Найдите наиболее популярный аэропорт прибытия для каждой из фамилий пассажиров.
-- Необходимые атрибуты пассажиров предварительно вынесите  в CTE.
with passenger_last_name as (select id, last_name from passenger)
select distinct on (p.last_name) count(*) count, p.last_name, t.arrival_airport
from passenger_last_name p
join ticket t on t.passenger_id = p.id
group by p.last_name, t.arrival_airport
order by p.last_name, count desc;

-- Задача 2
-- Посчитайте число билетов на рейсы до августа 2023 года,
-- сгруппировав их по аэропорту прибытия.
-- Отобразите для каждого совершеннолетнего пассажира число таких билетов для рейсов,
-- направляющихся в первый и второй их любимые аэропорты
-- (для каждого аэропорта, а также суммарное значение этих показателей).
with ticket_count as (
    select count(*) count, arrival_airport
    from ticket
    where arrival_date < '2023-08-01 00:00:00'
    group by arrival_airport
)
select p.id, tc1.count first_favorite_count, tc2.count second_favorite_count,
    (tc1.count + tc2.count) sum_favorite_count
from passenger p
left join ticket_count tc1 on tc1.arrival_airport = p.favorite_airports[1]
left join ticket_count tc2 on tc2.arrival_airport = p.favorite_airports[2]
where birth_date <= now() - make_interval(18);
-- Обратите внимание, если одно из слагаемых в колонке с суммой - NULL, сумма тоже будет NULL.
-- Решение может лежать в плоскости конструкции WHEN, с которой мы еще не знакомы