package com.walking.lesson34_date_time.task3;

import com.walking.lesson34_date_time.task3.exception.InputValidationException;
import com.walking.lesson34_date_time.task3.model.DateReport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static void main(String[] args) {
        String localDateTimePattern = "dd.MM.yyy HH:mm:ss";
        String localDateTimeExample = LocalDateTime.now()
                                                   .format(DateTimeFormatter.ofPattern(localDateTimePattern));
        String localDateTimeRequest = "Введите дату и время в формате %s (например %s):"
                .formatted(localDateTimePattern, localDateTimeExample);
        BufferedReader systemReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(localDateTimeRequest);
        String firstDateCandidate = getLine(systemReader);
        LocalDateTime firstDate = parseLocalDateTime(firstDateCandidate, localDateTimePattern);

        System.out.println(localDateTimeRequest);
        String secondDateCandidate = getLine(systemReader);
        LocalDateTime secondDate = parseLocalDateTime(secondDateCandidate, localDateTimePattern);

        DateReport dateReport = new DateReport(firstDate, secondDate);

        System.out.println(dateReport.getOverallView());
        System.out.println(dateReport.getSummaryView());

//        /* альтернативный вариант через наследников TemporalAccessor */
        System.out.println(dateReport.getAlternativeOverallView());
        System.out.println(dateReport.getAlternativeSummaryView());
    }

    private static LocalDateTime parseLocalDateTime(String candidate, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        try {
            return LocalDateTime.parse(candidate, dateTimeFormatter);
        } catch (DateTimeException e) {
            throw new InputValidationException(candidate, pattern, e);
        }
    }

    private static String getLine(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }
}
