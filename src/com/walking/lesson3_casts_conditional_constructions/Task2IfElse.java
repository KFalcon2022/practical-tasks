package com.walking.lesson3_casts_conditional_constructions;

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

        System.out.print("Write a message: ");
        String message = scanner.nextLine();

        scanner.close();

        if (message.equals("Hi")) {
            System.out.println("Hello");
        } else {
            if (message.equals("Bye")) {
                System.out.println("Good bye");
            } else {
                if (message.equals("How are you")) {
                    System.out.println("How are you doing");
                } else {
                    System.out.println("Unknown message");
                }
            }
        }
    }
}
