package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static void main(String[] args) {
        String inputDateTimeString;
        Scanner sc=new Scanner(System.in);
        System.out.println("Insert date and time:");
        LocalDateTime now=null;        
        LocalDateTime inputDateTime=null;
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        while (inputDateTime==null) {
            try {
                inputDateTimeString=sc.nextLine();
                now=LocalDateTime.now();
                inputDateTime=LocalDateTime.parse(inputDateTimeString, dtf);
            } catch (DateTimeParseException e) {
                System.out.println("Inserted string have wrong format, try again with: dd.MM.yyyy HH:mm:ss");
            }
        }
        sc.close();
        int compare=now.compareTo(inputDateTime);
        if (compare==0){
            System.out.println("Dates and time is same");
        }else if(compare<0){
            System.out.println("Inserted date and time is greater");
        } else{
            System.out.println("Inserted date and time is less");
        }

    }
}
