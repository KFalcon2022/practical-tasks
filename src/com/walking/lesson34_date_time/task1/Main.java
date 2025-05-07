package com.walking.lesson34_date_time.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String date = "20.12.2022 20:16:00";

        System.out.println(getDateTimeFromString(date));
    }

    public static LocalDateTime getDateTimeFromString(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);

        return localDateTime;
    }
}