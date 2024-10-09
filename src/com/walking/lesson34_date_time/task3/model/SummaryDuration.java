package com.walking.lesson34_date_time.task3.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SummaryDuration {
    static final int SECONDS_PER_MINUTE = 60;
    static final int MINUTES_PER_HOUR = 60;
    static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    static final int HOURS_PER_DAY = 24;
    static final int MONTHS_PER_YEAR = 12;

    private final long seconds;
    private final long minutes;
    private final long hours;
    private final long months;
    private final long days;
    private final long years;

    public SummaryDuration(LocalDateTime startDate, LocalDateTime endDate) {
        long AllSeconds = ChronoUnit.SECONDS.between(startDate, endDate);

        this.seconds = AllSeconds % SECONDS_PER_MINUTE;
        this.minutes = AllSeconds / SECONDS_PER_MINUTE % MINUTES_PER_HOUR;
        this.hours = AllSeconds / SECONDS_PER_HOUR % HOURS_PER_DAY;
        this.days = calculateDays(startDate, endDate);
        this.months = ChronoUnit.MONTHS.between(startDate, endDate) % MONTHS_PER_YEAR;
        this.years = ChronoUnit.YEARS.between(startDate, endDate);
    }

    private long calculateDays(LocalDateTime startDate, LocalDateTime endDate) {
        LocalDate start = startDate.toLocalDate();
        LocalDate end = endDate.toLocalDate();

        int daysOfStart = start.lengthOfMonth() - start.getDayOfMonth();
        int daysOfEnd = end.getDayOfMonth();

        return (daysOfStart + daysOfEnd) % end.lengthOfMonth();
    }

    @Override
    public String toString() {
        return "Summary: %s years, %s months, %s days, %s hours, %s minutes, %s seconds."
                .formatted(years, months, days, hours, minutes, seconds);
    }
}
