package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.*;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scanner.nextLine();
        scanner.close();

        Message message;

        switch (str) {
            case "Hi":
                message = new HelloMessage();
                break;
            case "Bye":
                message = new ByeMessage();
                break;
            case "How are you":
                message = new AskMessage();
                break;
            default:
                message = new UnknownMessage();
        }
        System.out.println(message.getMessage());
    }
}

