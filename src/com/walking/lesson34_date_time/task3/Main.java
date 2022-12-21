package com.walking.lesson34_date_time.task3;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static final String FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDateTime firstDate = getDate();
        LocalDateTime secondDate = getDate();
        SCANNER.close();

        System.out.println(getDateTimeDifference(firstDate, secondDate));
    }

    private static LocalDateTime getDate() {
        System.out.println("Enter a datetime:");
        String dateString = SCANNER.nextLine();

        return LocalDateTime.parse(dateString, FORMATTER);
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


    //        Альтернативный вариант. Не столько хорошее решение (хоть и лучше, чем основное),
//        сколько демонстрация функциональности, не затронутой в статье и
//        просто демонстрация различных подходов
    private static String getAdvancedDateTimeOrderedDifference(LocalDateTime firstDateTime,
                                                               LocalDateTime secondDateTime) {
        LocalDate secondDate = secondDateTime.minusSeconds(firstDateTime.toLocalTime().toSecondOfDay())
                .toLocalDate();

        Period period = Period.between(firstDateTime.toLocalDate(), secondDate);
        Duration duration = Duration.between(firstDateTime, secondDateTime);

//            Обратите внимание на возможность переиспользования параметра при форматировании строк.
//            Обычно, не самая лучшая идея, но иногда бывает полезна. Правда, здесь - не тот случай
        return """
                Seconds: %d
                Minutes: %d
                Hours: %d
                Days: %d
                Months: %d
                Years: %d
                Summary: %6$d years, %d months, %d days, %d hours %d minutes %d seconds
                """.formatted(
                getDateTimeDifference(firstDateTime, secondDateTime, ChronoUnit.SECONDS),
                getDateTimeDifference(firstDateTime, secondDateTime, ChronoUnit.MINUTES),
                getDateTimeDifference(firstDateTime, secondDateTime, ChronoUnit.HOURS),
                getDateTimeDifference(firstDateTime, secondDateTime, ChronoUnit.DAYS),
                getDateTimeDifference(firstDateTime, secondDateTime, ChronoUnit.MONTHS),
                getDateTimeDifference(firstDateTime, secondDateTime, ChronoUnit.YEARS),

                Math.abs(period.get(ChronoUnit.MONTHS)),
                Math.abs(period.get(ChronoUnit.DAYS)),
                Math.abs(duration.get(ChronoUnit.SECONDS) / 3600 % 24),
                Math.abs(duration.get(ChronoUnit.SECONDS) / 60 % 60),
                Math.abs(duration.get(ChronoUnit.SECONDS) % 60));
    }

    private static long getDateTimeDifference(LocalDateTime first, LocalDateTime second, TemporalUnit unit) {
        return Math.abs(unit.between(first, second));
    }
}
