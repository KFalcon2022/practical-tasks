
insert into passenger (first_name, last_name, birth_date, male, last_purchase, favorite_airports)
values ('Evgenii', 'Popelyshko', '04-13-1990', true, '05-20-2023', '{"Moscow", "Sochi", "Singapore"}'),
       ('Olga', 'Simonova', '11-21-1979', false, '12-20-2022', '{"Moscow", "Murmansk"}'),
       ('Darya', 'Smirnova', '08-05-1981', false, '07-01-2023', '{"Kaluga", "Sochi", "Moscow"}'),
       ('Andrei', 'Lepehin', '06-25-1989', true, '06-13-2023', '{"Moscow", "Sochi", "Cairo"}'),
       ('Andrei', 'Kharitonov', '12-13-1990', true, '04-20-2023', '{"Moscow", "Sochi"}'),
       ('Zarina', 'Bektleeva', '10-12-1988', false, '05-20-2023', '{"Moscow", "Dubai"}'),
       ('Alexey', 'Pupkin', '04-13-1990', true, '05-20-2023', '{"Minsk", "St. Petersburg"}'),
       ('Vladimir', 'Kolkol', '11-10-1984', true, null, null),
       ('Ivan', 'Melukh', '01-23-1979', true, '05-17-2023', '{"Brest", "Minsk"}'),
       ('Viktor', 'Zlobin', '08-24-1986', true, '01-20-2023', '{"Moscow", "Sochi"}');

select * from passenger where birth_date <= '07-16-2005' order by first_name;

select * from passenger where birth_date <= '07-16-2005' order by first_name offset 1 limit 2;



