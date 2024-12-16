package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.answer.Greeting;
import com.walking.lesson16_abstract_class_interface.task2.answer.impl.ByeAnswer;
import com.walking.lesson16_abstract_class_interface.task2.answer.impl.HiAnswer;
import com.walking.lesson16_abstract_class_interface.task2.answer.impl.HowAreYouAnswer;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = scanner.nextLine();

        scanner.close();

        Greeting greeting;

        switch (s) {
            case "Hi":
                greeting = new HiAnswer();
                break;

            case "Bye":
                greeting = new ByeAnswer();
                break;

            case "How are you":
                greeting = new HowAreYouAnswer();
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                System.out.println("Unknown message");
        }

    }
}
