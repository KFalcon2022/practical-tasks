-- Задача
-- Верните в одном запросе:
-- количество совершеннолетних пассажиров,
-- наибольшее и наименьшее значение последней покупки.
-- Сделайте группировку по полу
select count(*), max(last_purchase), min(last_purchase), male
from passenger
where birth_date <= now() - make_interval(18)
group by male;