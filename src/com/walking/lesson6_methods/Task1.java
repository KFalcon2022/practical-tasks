package com.walking.lesson6_methods;

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
        System.out.println("Введите строку");
        String str = scanner.nextLine();
        scanner.close();
        compareMessage(str);
    }

    static void print(String message) {
        System.out.println(message);
    }

    static void compareMessage(String message) {
        switch (message) {
            case "Hi" -> print("Hello");
            case "Bye" -> print("Good bye");
            case "How are you" -> print("How are doing");
            default -> print("Unknown message");
        }
    }
}
