package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.Answer;
import com.walking.lesson16_abstract_class_interface.task2.model.ByeAnswer;
import com.walking.lesson16_abstract_class_interface.task2.model.HiAnswer;
import com.walking.lesson16_abstract_class_interface.task2.model.HowAreYouAnswer;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string \"Hi\", \"Bye\" or \"How are you\": ");

        String inputString = scanner.nextLine();

        scanner.close();

        System.out.println(getAnswer(inputString));

    }

    static String getAnswer(String inputString) {
        Answer answer;

        switch(inputString) {
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
                return "Unknown input";
        }

        return answer.replay();
    }
}
