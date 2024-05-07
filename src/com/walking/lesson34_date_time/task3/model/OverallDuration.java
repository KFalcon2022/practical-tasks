package com.walking.lesson34_date_time.task3.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class OverallDuration {
    private final long seconds;
    private final long minutes;
    private final long hours;
    private final long days;
    private final long months;
    private final long years;

    public OverallDuration(LocalDateTime startDate, LocalDateTime endDate) {
        this.seconds = ChronoUnit.SECONDS.between(startDate, endDate);
        this.minutes = ChronoUnit.MINUTES.between(startDate, endDate);
        this.hours = ChronoUnit.HOURS.between(startDate, endDate);
        this.days = ChronoUnit.DAYS.between(startDate, endDate);
        this.months = ChronoUnit.MONTHS.between(startDate, endDate);
        this.years = ChronoUnit.YEARS.between(startDate, endDate);
    }

    @Override
    public String toString() {
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
}
