package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.GoodBye;
import com.walking.lesson16_abstract_class_interface.task2.model.Hello;
import com.walking.lesson16_abstract_class_interface.task2.model.HowAU;
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
        try {

            System.out.print("Enter string: ");
            String s = scanner.nextLine();
            scanner.close();

            Message message = getAnswer(s);
            System.out.println(message.answer());
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private static Message getAnswer(String s) throws Exception {
        switch (s) {
            case "Hi":
                return new Hello();
            case "Bye":
                return new GoodBye();
            case "How are you":
                return new HowAU();
            default:
                throw new Exception("I don't answer");
        }
    }
}
