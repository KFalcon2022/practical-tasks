package com.walking.lesson34_date_time.task3.service;

import com.walking.lesson34_date_time.task3.model.DateReport;

import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDateTime;

public class DateService {
    private final DateReport report;

    private DateService() {
        report = DateReport.of(getDateTimeFromConsole(), getDateTimeFromConsole());
    }

    public static DateService betweenTwo() {
       return new DateService();
    }

    public DateReport getReport() {
        return report;
    }

    /* альтернативный вариант через наследников TemporalAccessor */
    public String getAlternativeView() {
        return report.getAlternativeView();
    }

    private LocalDateTime getDateTimeFromConsole() {
        System.out.println("Введите дату и время в формате dd.mm.yyyy kk:mm:ss (например 20.12.2022 20:16:00):");

        String dateTimeCandidate = getInputFromConsole();

        LocalDateTime localDateTime = null;

        try {
            localDateTime = LocalDateTime.parse(dateTimeCandidate, DateReport.DATE_TIME_PATTERN);
        } catch (DateTimeException e) {
            System.out.println("Дата или время введены неверно");
        }

        return localDateTime;
    }

    private String getInputFromConsole() {
        FilterInputStream wrapper = new FilterInputStream(System.in) {
            @Override
            public void close() {
                /* помещаем поток System.in в обертку FilterInputStream
                 * с переопреденным методом, для предотвращения его закрытия */
            }
        };

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(wrapper))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }
}
