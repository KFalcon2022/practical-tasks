package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.greet.Goodbye;
import com.walking.lesson16_abstract_class_interface.task2.greet.Hello;
import com.walking.lesson16_abstract_class_interface.task2.greet.How;
import com.walking.lesson16_abstract_class_interface.task2.greet.Greeting;

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

        Greeting answer;
        switch (message) {
            case "Hi":
                answer = new Hello();
                break;
            case "Bye":
                answer = new Goodbye();
                break;
            case "How are you":
                answer = new How();
                break;
            default:
                answer = null;
        }

        if (answer != null) {
            System.out.println(answer.greet());
        } else {
            System.out.println("Unknown message");
        }
    }
}
