package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static final String FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);
        String inputString = getDate(scannerIn);
        scannerIn.close();

        System.out.println("You entered: "+ inputString);
        System.out.println("This date is "+checkInputDate(inputString)+" current date.");
    }
    private static String getDate(Scanner scannerIn){
        System.out.print("Enter your date: ");
        return scannerIn.nextLine();
    }
    private static String checkInputDate(String inputString){
        LocalDateTime inputDate = LocalDateTime.parse(inputString,FORMATTER);
        LocalDateTime currentDate = LocalDateTime.now();

        if (inputDate.isAfter(currentDate)){
            return "After";
        }
        if (inputDate.isBefore(currentDate)){
            return "Before";
        }
        return "The same";
    }
}
