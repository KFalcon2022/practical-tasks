package com.walking.lesson3;

import com.walking.lesson3.task2SwitchCaseInterfaces.*;

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
        String line = scanner.nextLine();
        scanner.close();

        Message message;

        switch (line) {
            case "Hi" : message = new Hello();
            break;
            case "Bye" : message = new Goodbye();
            break;
            case "How are you" : message = new HowAreYou();
            break;
            default: message = new Unknown();
        }

        System.out.println(message.getMessage());
    }
}
