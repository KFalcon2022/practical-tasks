package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.answer.Answer;
import com.walking.lesson16_abstract_class_interface.task2.answer.impl.ByeAnswer;
import com.walking.lesson16_abstract_class_interface.task2.answer.impl.HiAnswer;
import com.walking.lesson16_abstract_class_interface.task2.answer.impl.HowAreYouAnswer;
import com.walking.lesson16_abstract_class_interface.task2.answer.impl.UnknownAnswer;

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
        String greeting = scanner.nextLine();

        scanner.close();

        Answer answer;

        switch (greeting) {
            case "Hi":
                answer = new HiAnswer();
                break;

            case "Bye":
                answer = new ByeAnswer();
                break;

            case "How are you":
                answer = new HowAreYouAnswer();
                break;

            default:
                answer = new UnknownAnswer();
        }

        System.out.println(answer.getAnswer());
    }
}
