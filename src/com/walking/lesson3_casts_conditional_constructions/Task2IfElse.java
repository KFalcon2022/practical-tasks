package com.walking.lesson3_casts_conditional_constructions;

import java.util.Scanner;

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через if-else
 */
public class Task2IfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scanner.nextLine();
        scanner.close();

        String result;
        if ("Hi".equals(str)) {
            result = "Hello";
        } else if ("Bye".equals(str)) {
            result = "Good bye";
        } else if ("How are you".equals(str)) {
            result = "How are your doing";
        } else {
            result = "Unknown message";
        }

        System.out.println(result);

    }
}
