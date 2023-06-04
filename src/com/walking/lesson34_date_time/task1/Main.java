package com.walking.lesson34_date_time.task1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        LocalDateTime givenDT = createLdtFromString("20.12.2022 20:16:00");
        System.out.println(givenDT);

        LocalDateTime curDT = createLdtFromString("28.06.1932 02:51:56");
        System.out.println(curDT);

        System.out.println(givenDT.isAfter(curDT) ? "Input date " + givenDT + " > current date" : "Input date " + givenDT + " < current date");

        System.out.println(betweenLDT(givenDT, curDT));



    }

    static String betweenLDT(LocalDateTime date1, LocalDateTime date2){
        LocalDateTime d1;
        LocalDateTime d2;
        if (date1.isAfter(date2)){
            d1 = date2;
            d2 = date1;
        } else {
            d1 = date1;
            d2 = date2;
        }
        StringBuilder result = new StringBuilder();
        long csec = Math.abs(ChronoUnit.SECONDS.between(d1, d2));
        long min = Math.abs(ChronoUnit.MINUTES.between(d1, d2));
        long hrs = Math.abs(ChronoUnit.HOURS.between(d1, d2));
        long day = Math.abs(ChronoUnit.DAYS.between(d1, d2));
        long mon = Math.abs(ChronoUnit.MONTHS.between(d1, d2));
        long yrs = Math.abs(ChronoUnit.YEARS.between(d1, d2));

        result.append("Seconds: ");
        result.append(csec);
        result.append("\nMinutes: ");
        result.append(min);
        result.append("\nHours: ");
        result.append(hrs);
        result.append("\nDays: ");
        result.append(day);
        result.append("\nMonths: ");
        result.append(mon);
        result.append("\nYears: ");
        result.append(yrs);

        long sec = csec%60;
        min = min%60;
        hrs = hrs%24;
        mon = mon%12;
        if (d1.getDayOfMonth() < d2.getDayOfMonth()){
            day = d2.getDayOfMonth() - d1.getDayOfMonth();
        } else {
            day = d1.getMonth().maxLength() - (d1.getDayOfMonth() - d2.getDayOfMonth());
        }
        String sum = "\nSummary: " + yrs + " years, "
                + mon + " months, " + day + " days, "
                + hrs + " hours, " + min + " minutes and " + sec + " seconds";
        result.append(sum);

        return result.toString();
    }

    static LocalDateTime createLdtFromString(String dateTime) throws Exception {
        if (dateTime == null || dateTime.isEmpty()){
            return LocalDateTime.now();
        }
        String [] dt = dateTime.split(" ");

        if (dt.length < 2){
            throw new Exception("incorrect date");
        } else {
            String [] date = dt[0].split("\\.");
            String [] time = dt[1].split(":");
            if (date.length < 3 || time.length < 3){
                throw new Exception("incorrect date");
            }
            return LocalDateTime.of(Integer.parseInt(date[2]),
                    Integer.parseInt(date[1]),
                    Integer.parseInt(date[0]),
                    Integer.parseInt(time[0]),
                    Integer.parseInt(time[1]),
                    Integer.parseInt(time[2]));
        }





    }
}
