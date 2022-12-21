package com.walking.lesson34.Task2;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static final String pattern = "d.M.y H:m:s";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strdate = sc.nextLine();
        sc.close();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime date1 = LocalDateTime.from(dtf.parse(strdate));
        LocalDateTime date2 = LocalDateTime.now();

        if (date1.isBefore(date2)){
            System.out.println("before");
        }
        else if (date1.isAfter(date2)){
            System.out.println("after");
        } else {
            System.out.println("equal");
        }
    }
}
