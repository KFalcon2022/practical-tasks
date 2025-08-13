package com.walking.lesson3_casts_conditional_constructions;

import java.util.Scanner;

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через switch-case
 */
public class Task2SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scanner.nextLine();
        scanner.close();

        switch (str) {
            case "Hi":
                str = "Hello";
                break;
            case "Bye":
                str = "Good bye";
                break;
            case "How are you":
                str = "How are your doing";
                break;
            default:
                str = "Unknown message";
        }
        System.out.println(str);
    }
}
