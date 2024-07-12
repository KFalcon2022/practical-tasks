package com.walking.lesson34_date_time.task3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static void main(String[] args) {
        String s1;
        String s2;
        System.out.println("Insert 2 dates and time and i'll show you deference between them");
        Scanner sc=new Scanner(System.in);
        s1=sc.nextLine();
        s2=sc.nextLine();
        sc.close();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime d1=LocalDateTime.parse(s1,dtf);
        LocalDateTime d2=LocalDateTime.parse(s2,dtf);
        int sec=(int)d1.until(d2, ChronoUnit.SECONDS);
        int min=(int)d1.until(d2, ChronoUnit.MINUTES);
        int hours=(int)d1.until(d2, ChronoUnit.HOURS);
        int days=(int)d1.until(d2, ChronoUnit.DAYS);
        int months=(int)d1.until(d2, ChronoUnit.MONTHS);
        int years=(int)d1.until(d2, ChronoUnit.YEARS);
        System.out.printf("Deference is %d years or %d months or %d days or %d hours or %d minutes or %d seconds", years,months,days,hours,min,sec);
        //17.02.2018 05:06:07
        //30.09.2020 09:10:11
    }
}
