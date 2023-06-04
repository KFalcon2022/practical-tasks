package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.Bye;
import com.walking.lesson16_abstract_class_interface.task2.model.Hi;
import com.walking.lesson16_abstract_class_interface.task2.model.HowAreYou;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        switch (s) {
            case "Hi":
                s = new Hi().getAnswer();
                break;

            case "Bye":
                s = new Bye().getAnswer();
                break;

            case "How are you":
                s = new HowAreYou().getAnswer();
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                s = "Unknown message";
        }
        System.out.println(s);
    }
}
