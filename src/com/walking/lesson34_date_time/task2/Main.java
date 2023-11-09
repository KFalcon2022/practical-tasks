package com.walking.lesson34_date_time.task2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your date");
        Scanner in = new Scanner(System.in);

        LocalDateTime userDate = createLocalDate(in.nextLine());

        if(userDate.isAfter(LocalDateTime.now())) {
            System.out.println("Your date is after date now");
        }
        else if (userDate.isBefore(LocalDateTime.now())){
            System.out.println("Your date is before date now");
        }
        else {
            System.out.println("Your date is date now");
        }

        in.close();
    }
    public static LocalDateTime createLocalDate(String stringDate) {

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime localDate = LocalDateTime.parse(stringDate,formatter);

        return localDate;
    }
}
