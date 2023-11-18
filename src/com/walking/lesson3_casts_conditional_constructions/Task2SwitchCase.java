package src.com.walking.lesson3_casts_conditional_constructions;

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через switch-case
 */

import java.util.Scanner;

public class Task2SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сообщение: ");
        String message = scanner.nextLine();

        scanner.close();

        switch (message) {
            case "Hi" -> System.out.println("Hello");
            case "Bye" -> System.out.println("Good bye");
            case "How are you" -> System.out.println("How are your doing");
            default -> System.out.println("Unknown message");
        }
    }
}
