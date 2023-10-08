-- Задача 1
-- В рамках транзакции реализуйте добавление двух пассажиров и двух билетов для каждого из них.
-- Пассажир и его билеты должны быть добавлены даже если с другим пассажиром возникли проблемы.
-- Ошибка при добавлении билета не должна помешать добавлению всех остальных данных
-- (в т.ч. добавлению других билетов).
begin;
	savepoint p1;
-- Мы еще не знакомы с PL/SQL, поэтому айдишники и даты придется хардкодить. Это не совсем корректно,
-- но на данном уровне альтернативы нет
	insert into passenger (id, first_name, last_name, birth_date, male, last_purchase, favorite_airports)
		values (1, 'Ivan', 'Ivanov', '1990-12-20', true, now(), null);
-- В силу формулировки, по сути, каждое действие можно обернуть в сейвпоинт. Конечно, нет особого смысла пытаться
-- вставить билеты, если не был создан пассажир для них, однако средствами обычного SQL проблематично реализовать
-- такую вариативность (в следующих уроках мы познакомимся со средствами, это упрощяющими).
-- Также можно использовать запрос RELEASE SAVEPOINT для удаления неиспользованного сейвпоинта из памяти, если запрос
-- применился успешно
--	rollback to p1;

	savepoint p1t1;
	insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
		values ('Minsk', 'Riga', '2023-10-08 10:00:00', '2023-10-08 11:00:00', now(), 1);
--	rollback to p1t1;

	savepoint p1t2;
	insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
		values ('Riga', 'Minsk', '2023-10-09 10:00:00', '2023-10-09 11:00:00', now(), 1);
--	rollback to p1t2;

	savepoint p2;
	insert into passenger (id, first_name, last_name, birth_date, male, last_purchase, favorite_airports)
		values (2, 'Petr', 'Ivanov', '1990-12-20', true, now(), null);
--	rollback to p2;

	savepoint p2t2;
	insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
		values ('Minsk', 'Riga', '2023-10-08 10:00:00', '2023-10-08 11:00:00', now(), 2);
--	rollback to p2t2;

	savepoint p2t2;
	insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
		values ('Riga', 'Minsk', '2023-10-09 10:00:00', '2023-10-09 11:00:00', now(), 2);
--	rollback to p2t2;
commit;

-- Задача 2
-- Добавьте еще двух пассажиров, но теперь они берут билеты туда-обратно (Скажем, Минск-Москва и Москва-Минск).
-- Поэтому при возникновении проблем с добавлением одного из билетов, второй тоже не должен быть добавлен.
-- Сам пассажир, при этом, должен быть сохранен.
begin;
	savepoint p3;
	insert into passenger (id, first_name, last_name, birth_date, male, last_purchase, favorite_airports)
		values (3, 'Ivan', 'Ivanov', '1990-12-20', true, now(), null);
--	rollback to p3;

-- Первый вариант реализации отката при ошибке в одной из вставок
	savepoint p3t;
	insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
		values
		('Minsk', 'Riga', '2023-10-08 10:00:00', '2023-10-08 11:00:00', now(), 3),
		('Riga', 'Minsk', '2023-10-09 10:00:00', '2023-10-09 11:00:00', now(), 3);
--	rollback to p3t;

	savepoint p4;
	insert into passenger (id, first_name, last_name, birth_date, male, last_purchase, favorite_airports)
		values (4, 'Petr', 'Ivanov', '1990-12-20', true, now(), null);
--	rollback to p4;

-- Второй вариант реализации отката при ошибке в одной из вставок
    savepoint p4t;
    insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
    		values ('Riga', 'Minsk', '2023-10-08 10:00:00', '2023-10-08 11:00:00', now(), 4);
-- Если первый запрос упадет с ошибкой - второй не будет исполнен, т.к. в транзакции уже возникла ошибка.
-- Ролбэк к сейвпоинту решит эту ситуацию
    insert into ticket (departure_airport, arrival_airport, departure_date, arrival_date, purchase_date, passenger_id)
    		values ('Riga', 'Minsk', '2023-10-09 10:00:00', '2023-10-09 11:00:00', now(), 4);
--	rollback to p4t;
commit;