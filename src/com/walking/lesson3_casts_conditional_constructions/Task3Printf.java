package com.walking.lesson3_casts_conditional_constructions;

import java.util.Scanner;

/**
 * Завести три переменные типа String.
 * С клавиатуры ввести в них вашу фамилию, имя и отчество.
 * Вывести в консоль в одну строку ваше ФИО.
 * Сделать, используя System.out.printf
 */
public class Task3Printf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите отчество: ");
        String patronymic = scanner.nextLine();
        System.out.printf("Ваше ФИО: %s %s %s", surname, name, patronymic);
        scanner.close();
    }
}
