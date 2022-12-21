package com.walking.lesson34.Task3;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;
public class Main
{
    public static final String pattern = "d.M.y H:m:s";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strdate1 = sc.nextLine(); // "20.12.2022 20:16:00"
        String strdate2 = sc.nextLine(); // "28.06.1932 02:51:56"
        sc.close();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime date1 = LocalDateTime.from(dtf.parse(strdate1));
        LocalDateTime date2 = LocalDateTime.from(dtf.parse(strdate2));

        /* Шуточное решение.
        ZoneOffset zone = ZoneOffset.of("Z");
        long l = Math.abs(date1.toEpochSecond(zone) - date2.toEpochSecond(zone));

        System.out.println("Seconds: " + l);
        System.out.println("Minutes: " + (l / 60));
        System.out.println("Hours: " + (l / 60 / 60));
        System.out.println("Days: " + (l / 60 / 60 / 24));
        System.out.println("Months: " + (l / 60 / 60 / 24 / 365 * 12)); // приблизительно
        System.out.println("Years: " + (l / 60 / 60 / 24 / 365)); // приблизительно
         */

        System.out.println("Seconds: " + getTimeParticle(date1, date2, ChronoUnit.SECONDS));
        System.out.println("Minutes: " + getTimeParticle(date1, date2, ChronoUnit.MINUTES));
        System.out.println("Hours: " + getTimeParticle(date1, date2, ChronoUnit.HOURS));
        System.out.println("Days: " + getTimeParticle(date1, date2, ChronoUnit.DAYS));
        System.out.println("Months: " + getTimeParticle(date1, date2, ChronoUnit.MONTHS));
        System.out.println("Years: " + getTimeParticle(date1, date2, ChronoUnit.YEARS));
    }

    public static long getTimeParticle(LocalDateTime t1, LocalDateTime t2, TemporalUnit unit){
        return Math.abs(t1.until(t2, unit));
    }
}