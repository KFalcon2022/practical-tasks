package com.walking.lesson6_methods;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Декомпозировать задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/lesson3/Task2SwitchCase.java">...</a>
 * Вынести в отдельный метод использование switch-case.
 * Также вынести в отдельный метод использование System.out.println
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String message = scanner.nextLine();
        scanner.close();

        printAnotherMessage(message);
    }

    public static void printAnotherMessage(String phrase) {
        String message;
        switch (phrase) {
            case "Hi":
                message = "Hello";
                break;

            case "Bye":
                message = "Good bye";
                break;

            case "How are you":
                message = "How are your doing";
                break;

            default:
                message = "Unknown message";
        }
        System.out.println(message);
    }
}

