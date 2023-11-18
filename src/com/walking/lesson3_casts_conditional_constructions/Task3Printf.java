package com.walking.lesson3_casts_conditional_constructions;

/**
 * Завести три переменные типа String.
 * С клавиатуры ввести в них вашу фамилию, имя и отчество.
 * Вывести в консоль в одну строку ваше ФИО.
 * Сделать, используя System.out.printf
 */

import java.util.Scanner;

public class Task3Printf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите свою фамилию: ");
        String surname = scanner.nextLine();
        System.out.print("Введите свое имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите свое отчество: ");
        String middleName = scanner.nextLine();

        scanner.close();

        System.out.printf("Ваше ФИО: %s %s %s", surname, name, middleName);
    }
}
