-- Задача 1
-- Реализуйте добавление добавление пассажира и двух билетов для него в виде процедуры. id пассажира и билетов должны быть:
--      Вариант 1: Вшиты в процедуру;
--      Вариант 2: Передаваться параметрами.
-- Язык можете выбрать на свой вкус.

-- Вариант 1:
create procedure insert_passenger_and_tickets()
language plpgsql
as $$
  declare
    passenger_id bigint;
  begin
    insert into passenger (first_name, last_name, birth_date, male, last_purchase, favorite_airports)
    		values ('Ivan', 'Ivanov', '1990-12-20', true, now(), null)
-- Обратите вниимание, раньше мы не использовали предложение returning для insert.
-- Из-за этого хардкод тоже может быть допустимым решением
    returning id into passenger_id;

    insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
    		values
    		('Minsk', 'Riga', '2023-10-08 10:00:00', '2023-10-08 11:00:00', now(), passenger_id),
    		('Riga', 'Minsk', '2023-10-09 10:00:00', '2023-10-09 11:00:00', now(), passenger_id);
  end
$$;

-- Вариант 2:
create procedure insert_passenger_and_tickets(passenger_id bigint, ticket1_id bigint, ticket2_id bigint)
language sql
as $$
    insert into passenger (id, first_name, last_name, birth_date, male, last_purchase, favorite_airports)
    		values (passenger_id, 'Ivan', 'Ivanov', '1990-12-20', true, now(), null);

    insert into ticket (id, departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
    		values
    		(ticket1_id, 'Minsk', 'Riga', '2023-10-08 10:00:00', '2023-10-08 11:00:00', now(), passenger_id),
    		(ticket2_id, 'Riga', 'Minsk', '2023-10-09 10:00:00', '2023-10-09 11:00:00', now(), passenger_id);
$$;

-- Задача 2
-- Реализуйте примеры из раздела "Синтаксис для работы с функциями", используя SQL, вместо PL/pgSQL.
create or replace function sum_params(a bigint, b bigint) returns bigint
language sql
as $$
    select a + b;
$$;

create or replace function next_t1_id_seq() returns bigint
language sql
as $$
    select nextval('t1_id_seq');
$$;

-- В реальных задачах так делать не надо. Здесь это лишь демонстрация на тему "нет ничего невозможного"
-- и напоминание о широте возможностей CTE.
-- В целом, SQL не позволяет вводить переменные, из-за чего подобные задачи лучше решать средствами PL/SQL.
create or replace function insert_data_f() returns boolean
language sql
as $$
    with t1_id1 as (select next_t1_id_seq()),
         t1_id2 as (select next_t1_id_seq()),
         insert_query as (insert into t1 values
             ((select * from t1_id1), 1),
             ((select * from t1_id2), 1)
             returning 0)
    insert into t2 (t1_id) values
         ((select * from t1_id1)),
         ((select * from t1_id1)),
         ((select * from t1_id2));

    select true;
$$;
