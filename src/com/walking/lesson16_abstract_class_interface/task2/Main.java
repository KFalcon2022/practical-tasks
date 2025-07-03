package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.greet.*;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter message: ");
        String message = in.nextLine();

        System.out.println(getGreeting(message));
    }

    private static Greeting getGreeting(String message) {
        return switch (message) {
            case "Hi" -> new Hello();
            case "Bye" -> new Goodbye();
            case "How are you" -> new How();
            default -> new Unknown();
        };
    }
}
