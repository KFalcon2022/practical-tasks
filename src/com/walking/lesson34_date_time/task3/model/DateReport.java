package com.walking.lesson34_date_time.task3.model;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;

public class DateReport {
    private final OverallDuration overallDuration;
    private final SummaryDuration summaryDuration;

    /* альтернативный вариант через наследников TemporalAccessor */
    private final Period period;
    private final Duration duration;


    public DateReport(LocalDateTime first, LocalDateTime second) {
        LocalDateTime startDate = pickStartDate(first, second);
        LocalDateTime endDate = pickEndDate(first, second);
        overallDuration = new OverallDuration(startDate, endDate);
        summaryDuration = new SummaryDuration(startDate, endDate);

        period = Period.between(startDate.toLocalDate(), endDate.toLocalDate());
        duration = Duration.between(startDate, endDate);
    }

    private LocalDateTime pickStartDate(LocalDateTime first, LocalDateTime second) {
        return first.isBefore(second) ? first : second;
    }

    private LocalDateTime pickEndDate(LocalDateTime first, LocalDateTime second) {
        return first.isAfter(second) ? first : second;
    }

    public String getOverallView() {
        return overallDuration.toString();
    }

    public String getSummaryView() {
        return summaryDuration.toString();
    }

    /* альтернативный вариант через наследников TemporalAccessor */
    public String getAlternativeOverallView() {
        long seconds = duration.getSeconds();
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();
        long months = period.toTotalMonths();
        long years = period.getYears();

        return """
                Overall:
                Seconds: %s
                Minutes: %s
                Hours: %s
                Days: %s
                Months: %s
                Years: %s
                """.formatted(seconds, minutes, hours, days, months, years);
    }

    public String getAlternativeSummaryView() {
        long seconds = duration.toSeconds() % Duration.ofMinutes(1).toSeconds();
        long minutes = duration.toMinutes() % Duration.ofHours(1).toMinutes();
        long hours = duration.toHours() % Duration.ofDays(1).toHours();
        long days = period.getDays();
        long months = period.getMonths();
        long years = period.getYears();

        return "Summary: %s years, %s months, %s days, %s hours, %s minutes, %s seconds."
                .formatted(years, months, days, hours, minutes, seconds);
    }
}