-- Задача
-- Проанализируйте SELECT-запросы, представленные в практике к предыдущим урокам.
-- Добавьте индексы на колонки, которые наиболее часто использовались для фильтрации и сортировки данных.
-- Везде ли типом индекса стоит выбрать BTREE? Требуются ли составные индексы в рамках этой задачи?

-- На примере таблицы passenger. Наиболее популярны (исходя из выыполненных задач) фильтры по:
--    дате рождения с использованием операторов сравнения;
--    имени с использованием = и like/ilike;
--    полу (по значению).
-- Исходя из этого добавим индексы:
create index i_passenger_birth_date             on passenger (birth_date);
-- Учитывая фильтры по like, имело бы смысл добавить, например, gist/gin-индекс с использованием триграмм:
-- create index i_passenger_first_name_trgm        on passenger                using gin(lower(first_name) gin_trgm_ops);
-- Но для использования gin_trgm_ops необходимо подключать внешнее расширение (extension) к pg,
-- поэтому обойдемся вариантом попроще:
create index i_passenger_first_name_trgm        on passenger (first_name);
create index i_passenger_male                   on passenger using hash (male);
