package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.GoodByeMessage;
import com.walking.lesson16_abstract_class_interface.task2.model.HelloMessage;
import com.walking.lesson16_abstract_class_interface.task2.model.HowAreYouMessage;
import com.walking.lesson16_abstract_class_interface.task2.model.Message;

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

        Message message = getAnswer(s);
        if (message == null) {
            System.out.println("I don't known.");
            return;
        }
        System.out.println(message.answer());
    }

    private static Message getAnswer(String s) {
        switch (s) {
            case "Hi":
                return new HelloMessage();
            case "Bye":
                return new GoodByeMessage();
            case "How are you":
                return new HowAreYouMessage();
            default:
                return null;
        }
    }
}
