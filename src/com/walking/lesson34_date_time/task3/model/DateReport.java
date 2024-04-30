package com.walking.lesson34_date_time.task3.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateReport {
    public static final int SECONDS_IN_MINUTE = 60;
    public static final int MINUTES_IN_HOURS = 60;
    public static final int HOURS_IN_DAY = 24;
    public static final int MONTHS_IN_YEAR = 12;
    public static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("dd.MM.yyy kk:mm:ss");
    public static final Separately ZERO_SEPARATELY = Separately.getZero();
    public static final Summary ZERO_SUMMARY = Summary.getZero();

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Separately separately;
    private final Summary summary;

    /* альтернативный вариант через наследников TemporalAccessor */
    private final Period period;
    private final Duration duration;

    private DateReport(LocalDateTime startDate, LocalDateTime endDate, Separately separately,
                       Summary summary, Period period, Duration duration) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.separately = separately;
        this.summary = summary;
        this.period = period;
        this.duration = duration;
    }

    private DateReport(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.separately = new Separately(startDate, endDate);
        this.summary = new Summary(separately, startDate, endDate);
        this.period = Period.between(startDate.toLocalDate(), endDate.toLocalDate());
        this.duration = Duration.between(startDate, endDate);
    }

    private static DateReport fromSameDate(LocalDateTime date) {
        return new DateReport(date, date, ZERO_SEPARATELY, ZERO_SUMMARY, Period.ZERO, Duration.ZERO);
    }

    private static DateReport ofDifferentDate(LocalDateTime startDate, LocalDateTime endDate) {
        return new DateReport(startDate, endDate);
    }

    public static DateReport of(LocalDateTime someone, LocalDateTime another) {
        LocalDateTime startDate;
        LocalDateTime endDate;

        if (someone == null || another == null) {
            throw new NullPointerException("LocalDateTime = null, not allowed here");
        }

        if (someone.isAfter(another)) {
            endDate = someone;
            startDate = another;
        } else if (another.isAfter(someone)) {
            endDate = another;
            startDate = someone;
        } else {
            //если даты одинаковы вернуть объект с предзаполненными полями (без расчетов)
            return fromSameDate(someone);
        }

        return ofDifferentDate(startDate, endDate);
    }

    /* альтернативный вариант через наследников TemporalAccessor */
    public String getAlternativeView() {
        long seconds = duration.getSeconds();
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();
        long months = period.toTotalMonths();
        long years = period.getYears();

        long secondsGap = duration.toSeconds() % Duration.ofMinutes(1).toSeconds();
        long minutesGap = duration.toMinutes() % Duration.ofHours(1).toMinutes();
        long hoursGap = duration.toHours() % Duration.ofDays(1).toHours();
        long monthsGap = period.getMonths();
        long daysGap = period.getDays();
        long yearsGap = period.getYears();

        String separately = """
                Seconds: %s
                Minutes: %s
                Hours: %s
                Days: %s
                Months: %s
                Years: %s""".formatted(seconds, minutes, hours, days, months, years);

        String summary = "Summary: %s years, %s months, %s days, %s hours, %s minutes, %s seconds."
                .formatted(yearsGap, monthsGap, daysGap, hoursGap, minutesGap, secondsGap);

        return """
                Между датой: %S
                    и датой: %S
                --------------------------------
                %s
                --------------------------------
                %s
                """.formatted(startDate.format(DATE_TIME_PATTERN), endDate.format(DATE_TIME_PATTERN), separately, summary);
    }

    @Override
    public String toString() {
        return """
                Между датой: %S
                    и датой: %S
                --------------------------------
                %s
                --------------------------------
                %s
                """.formatted(startDate.format(DATE_TIME_PATTERN), endDate.format(DATE_TIME_PATTERN), separately, summary);
    }

    private static class Separately {
        private final long seconds;
        private final long minutes;
        private final long hours;
        private final long days;
        private final long months;
        private final long years;

        private Separately() {
            this.seconds = 0;
            this.minutes = 0;
            this.hours = 0;
            this.days = 0;
            this.months = 0;
            this.years = 0;
        }

        private Separately(LocalDateTime startDate, LocalDateTime endDate) {
            this.seconds = ChronoUnit.SECONDS.between(startDate, endDate);
            this.minutes = ChronoUnit.MINUTES.between(startDate, endDate);
            this.hours = ChronoUnit.HOURS.between(startDate, endDate);
            this.days = ChronoUnit.DAYS.between(startDate, endDate);
            this.months = ChronoUnit.MONTHS.between(startDate, endDate);
            this.years = ChronoUnit.YEARS.between(startDate, endDate);
        }

        private static Separately getZero() {
            return new Separately();
        }

        @Override
        public String toString() {
            return """
                    Seconds: %s
                    Minutes: %s
                    Hours: %s
                    Days: %s
                    Months: %s
                    Years: %s""".formatted(seconds, minutes, hours, days, months, years);
        }
    }

    private static class Summary {
        private final long secondsGap;
        private final long minutesGap;
        private final long hoursGap;
        private final long monthsGap;
        private final long daysGap;
        private final long yearsGap;

        private Summary() {
            secondsGap = 0;
            minutesGap = 0;
            hoursGap = 0;
            monthsGap = 0;
            daysGap = 0;
            yearsGap = 0;
        }

        private Summary(Separately separately, LocalDateTime startDate, LocalDateTime endDate) {
            secondsGap = separately.seconds % SECONDS_IN_MINUTE;
            minutesGap = separately.minutes % MINUTES_IN_HOURS;
            hoursGap = separately.hours % HOURS_IN_DAY;
            monthsGap = separately.months % MONTHS_IN_YEAR;
            daysGap = calculateDaysGap(startDate.toLocalDate(), endDate.toLocalDate());
            yearsGap = separately.years;
        }

        private static Summary getZero() {
            return new Summary();
        }

        private long calculateDaysGap(LocalDate startDate, LocalDate endDate) {
            int daysOfStart = startDate.lengthOfMonth() - startDate.getDayOfMonth();
            int daysOfEnd = endDate.getDayOfMonth();
            return (daysOfStart + daysOfEnd) % startDate.lengthOfMonth();
        }

        @Override
        public String toString() {
            return "Summary: %s years, %s months, %s days, %s hours, %s minutes, %s seconds."
                    .formatted(yearsGap, monthsGap, daysGap, hoursGap, minutesGap, secondsGap);
        }
    }
}




