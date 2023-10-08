-- Задача 1
-- Реализуйте логирование действий для всех таблиц в тестовой БД в виде FOR EACH STATEMENT триггеров,
-- которые будут писать в таблицу логов примененную операцию, таблицу,
-- к которой была применена операция и дату срабатывания триггера.
create table test_db_log (
  table_name       varchar(100)  not null,
  action_type      varchar(10)   not null,
  happened         timestamp     not null default now()
);

create or replace function log_test_db() returns trigger
language plpgsql
as $$
  declare
  begin
    insert into test_db_log(table_name, action_type)
      values (TG_TABLE_NAME, TG_OP);

    return null;
  end
$$;

create or replace trigger log_test_db
after update or insert or delete or truncate on passenger
for each statement
execute procedure log_test_db();

create or replace trigger log_test_db
after update or insert or delete or truncate on passenger_favorite_airport
for each statement
execute procedure log_test_db();

create or replace trigger log_test_db
after update or insert or delete or truncate on ticket
for each statement
execute procedure log_test_db();

create or replace trigger log_test_db
after update or insert or delete or truncate on airport
for each statement
execute procedure log_test_db();

create or replace trigger log_test_db
after update or insert or delete or truncate on flight
for each statement
execute procedure log_test_db();

create or replace trigger log_test_db
after update or insert or delete or truncate on "user"
for each statement
execute procedure log_test_db();

-- Задача 2
-- Реализуйте триггер, который будет переводить имя и фамилию
-- в верхний регистр при добавлении или изменении
-- (имени или фамилии) пассажира.

create or replace function passenger_name_upper_case() returns trigger
language plpgsql
as $$
  declare
  begin
    new.first_name = upper(new.first_name);
    new.last_name = upper(new.last_name);

    return new;
  end
$$;

create or replace trigger passenger_name_upper_case
before update or insert on passenger
for each row
execute procedure passenger_name_upper_case();
