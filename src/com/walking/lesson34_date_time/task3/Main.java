package com.walking.lesson34_date_time.task3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static void main(String[] args) {

        LocalDateTime firstDate = createDate("2022-12-12 12:00:00");
        LocalDateTime secondDate = createDate("1922-10-12 12:00:00");


        System.out.println(getDateTimeDifference(firstDate, secondDate));
    }

    public static LocalDateTime createDate (String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(stringDate,formatter);

        return localDateTime;
    }

    private static String getDateTimeDifference(LocalDateTime first, LocalDateTime second) {
        LocalDateTime begin;
        LocalDateTime end;

        if (first.isBefore(second)) {
            begin = first;
            end = second;
        } else {
            begin = second;
            end = first;
        }

        return getDateTimeOrderedDifference(begin, end);
    }

    private static String getDateTimeOrderedDifference(LocalDateTime first, LocalDateTime second) {
        long firstSeconds = first.toEpochSecond(ZoneOffset.UTC);
        long secondSeconds = second.toEpochSecond(ZoneOffset.UTC);

        long fullSecondDifference = Math.abs(secondSeconds - firstSeconds);
        long fullMinuteDifference = fullSecondDifference / 60;
        long fullHourDifference = fullMinuteDifference / 60;
        long fullDayDifference = fullHourDifference / 24;

        long differenceSecondOfDay = getDifferenceSecondOfDay(first, second);

        LocalDate reducedTimeSecondDate = second.minusSeconds(differenceSecondOfDay)
                .toLocalDate();

        long monthDifference = getMonthDifference(first.toLocalDate(), reducedTimeSecondDate);

        return """
                Seconds: %d
                Minutes: %d
                Hours: %d
                Days: %d
                Months: %d
                Years: %d
                Summary: %6$d years, %d months, %d days, %d hours %d minutes %d seconds
                """.formatted(
                fullSecondDifference,
                fullMinuteDifference,
                fullHourDifference,
                fullDayDifference,
                monthDifference,
                monthDifference / 12,
                monthDifference % 12,
                getDayDifference(first.toLocalDate(), reducedTimeSecondDate),
                fullHourDifference % 24,
                fullMinuteDifference % 60,
                fullSecondDifference % 60
        );
    }

    private static long getDifferenceSecondOfDay(LocalDateTime first, LocalDateTime second) {
        long firstSecondOfDay = first.toLocalTime().toSecondOfDay();
        long secondSecondOfDay = second.toLocalTime().toSecondOfDay();

        return secondSecondOfDay >= firstSecondOfDay
                ? secondSecondOfDay - firstSecondOfDay
                : 60 * 60 * 24 - (firstSecondOfDay - secondSecondOfDay);
    }

    //    Честно переделанный LocalDate:until() под текущие потребности
    private static long getMonthDifference(LocalDate first, LocalDate second) {
        long monthDifference = 12L * (second.getYear() - first.getYear()) + second.getMonthValue() - first.getMonthValue();
        int dayDifference = second.getDayOfMonth() - first.getDayOfMonth();

        if (monthDifference > 0 && dayDifference < 0) {
            monthDifference--;
        } else if (monthDifference < 0 && dayDifference > 0) {
            monthDifference++;
        }

        return Math.abs(monthDifference);
    }

    private static int getDayDifference(LocalDate first, LocalDate second) {
        if (second.getDayOfMonth() >= first.getDayOfMonth()) {
            return second.getDayOfMonth() - first.getDayOfMonth();
        }

        return first.getMonth().maxLength() - (first.getDayOfMonth() - second.getDayOfMonth());
    }
}
