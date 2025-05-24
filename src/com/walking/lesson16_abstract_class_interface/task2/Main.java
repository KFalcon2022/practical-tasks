package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.printer.*;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = requireString("Enter String: ");
        scanner.close();

        createAnswer(s).getAnswer();
    }

    private static String requireString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static AnswerCreator createAnswer(String question) {

        switch (question) {
            case "Hi":
                return new Hi();
            case "How are you":
                return new HowAreYou();
            case "Bye":
                return new Bye();
            default:
                return new UnknownAnswer();

        }
    }
}
// Не подсматривал - всё сам)
// Но возник вопрос% Мы должны переопределть все методы Интерфейса,
// кроме помеченных как static и default, верно?