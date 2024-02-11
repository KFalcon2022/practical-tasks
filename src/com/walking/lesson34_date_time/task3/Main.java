package com.walking.lesson34_date_time.task3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static final String FORMATTER_PATTERN="dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern(FORMATTER_PATTERN);
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);
        LocalDateTime dateTime1=getDateTime(scannerIn);
        LocalDateTime dateTime2 = getDateTime(scannerIn);
        scannerIn.close();

        displayTimeDifference(dateTime1,dateTime2);


    }
    private static LocalDateTime getDateTime(Scanner scannerIn){
        System.out.print("Enter date and time: ");
        String resultStr=scannerIn.nextLine();
        return LocalDateTime.parse(resultStr,FORMATTER);
    }
    private static void displayTimeDifference(LocalDateTime dateTime1, LocalDateTime dateTime2){
        ChronoUnit[] chronoUnitsDisplay=new ChronoUnit[]
                {ChronoUnit.SECONDS,ChronoUnit.MINUTES,ChronoUnit.HOURS,ChronoUnit.DAYS,ChronoUnit.MONTHS,ChronoUnit.YEARS};
        long[] timeUnits=new long[chronoUnitsDisplay.length];
        int index=0;
        for (ChronoUnit chronoUnit : chronoUnitsDisplay){
            long timeUnit = Math.abs(dateTime1.until(dateTime2, chronoUnit));
            String dateUnit=chronoUnit.toString();
            timeUnits[index]=timeUnit;
            index++;
            System.out.println(dateUnit+": "+timeUnit);
        }
        System.out.println(getSummaryString(timeUnits));
    }
    private static String getSummaryString(long[] timeUnits){
        Arrays.sort(timeUnits);
        return String.format("Summary: %d years, %d months, %d days, %d hours, %d minutes, %d seconds",
                timeUnits[0],timeUnits[1],timeUnits[2],timeUnits[3],timeUnits[4],timeUnits[5]);
    }
}
