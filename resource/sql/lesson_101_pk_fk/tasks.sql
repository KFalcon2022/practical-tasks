-- Задача
-- Для таблиц, созданных в рамках практики к Уроку 99 добавьте PK и FK.
-- Также добавьте их для остальных таблиц в рамках тестовой БД.
-- Включая passenger и ticket.

-- Для не пустых таблиц может потребоваться очистка данных с дублирующимися id
alter table passenger                       add primary key (id);
alter table ticket                          add primary key (id);
alter table airport                         add primary key (id);
alter table flight                          add primary key (id);
alter table "user"                          add primary key (id);
alter table passenger_favorite_airport      add primary key (passenger_id, airport_id);


alter table ticket add foreign key (passenger_id) references passenger(id);

alter table passenger_favorite_airport
	add foreign key (passenger_id)                  references passenger(id),
	add foreign key (airport_id)                    references airport(id);

alter table flight
    add foreign key (departure_airport_id)          references airport(id),
    add foreign key (arrival_airport_id)            references airport(id);
