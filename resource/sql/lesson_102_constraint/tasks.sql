-- Задача
-- Добавьте в рамках тестовой БД необходимые UNIQUE и NOT NULL
-- ограничения сущностям в соответствии с их ролью.
-- При необходимости можете использовать и иные виды констрэинтов.
alter table passenger
    alter column first_name             set not null,
    alter column last_name              set not null,
    alter column birth_date             set not null,
    alter column male                   set not null;

alter table ticket
-- Конечно, правильнее было бы актуализировать таблицу, проставив связь с flight.
-- Но в силу отсутствия прямого задания на это - в разборе показано решения для последней опубликованной версии.
    alter column departure_airport      set not null,
    alter column arrival_airport        set not null,
-- Опционально можно добавить CHECK-constraint'ы на несовпадение аэропортов отправления и прибытия, валидацию дат
    alter column departure_date         set not null,
    alter column arrival_date           set not null,
    alter column purchase_date          set not null,
    alter column passenger_id           set not null,
-- Актуализируй мы таблицу, здесь бы было лишь 2 колонки, вместо 5
    add unique (departure_airport, arrival_airport, departure_date, arrival_date, passenger_id);

alter table airport
    alter column code                    set not null,
    alter column name                    set not null,
    add unique (code),
    add unique (name);

alter table flight
    alter column number                  set not null,
    alter column departure_airport_id    set not null,
    alter column arrival_airport_id      set not null,
    alter column departure_date          set not null,
    alter column arrival_date            set not null,
    add unique (departure_airport_id, arrival_airport_id, departure_date, arrival_date),
    add check (departure_airport_id != arrival_airport_id),
    add check (departure_date < arrival_date);

alter table "user"
    alter column username                    set not null,
    alter column password                   set not null,
    add unique (username);