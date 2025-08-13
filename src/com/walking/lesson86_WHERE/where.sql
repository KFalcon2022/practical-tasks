
select * from passenger where id = 1;

select * from passenger where favorite_airports is null;

select * from passenger where (first_name = 'Petr' and passenger.last_name = 'Petrov') and birth_date < last_purchase;