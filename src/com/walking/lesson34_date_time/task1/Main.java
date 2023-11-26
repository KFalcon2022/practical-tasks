package com.walking.lesson34_date_time.task1;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
   private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        LocalDateTime inputDate1 = inputDate();
        LocalDateTime inputDate2 = inputDate();

        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("");
        differencesBettwen(inputDate1, inputDate2);
    }
    private static LocalDateTime inputDate(){
        LocalDateTime date;
        try {
            System.out.println("Введите время в формате dd.MM.yyyy HH:mm:ss");
            String input = reader.readLine();
           date = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
    private static void differencesBettwen(LocalDateTime date1, LocalDateTime date2){
        System.out.println( ChronoUnit.SECONDS.between(date2, date1));
        System.out.println( ChronoUnit.MINUTES.between(date2, date1));
        System.out.println( ChronoUnit.HOURS.between(date2, date1));
        System.out.println( ChronoUnit.DAYS.between(date2, date1));
        System.out.println( ChronoUnit.MONTHS.between(date2, date1));
        System.out.println( ChronoUnit.YEARS.between(date2, date1));
        System.out.println(getLast(date1, date2));
    }
    private static String getLast(LocalDateTime date1, LocalDateTime date2){
       long s=ChronoUnit.SECONDS.between(date2, date1);
        long years = (s/3600/24/365);
       long seconds = s%60;
       long minutes = (s/60)%60;
       long hours = (s/3600)%24;
        long days = (s/3600/24)%30;
        long months = (s/3600/24/30)%12;

       return String.format("Summary: %d years, %d month, %d days, %d hours, %d minutes,%d ssecondos", years, months, days, hours, minutes, seconds);
    }
}
