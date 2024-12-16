package com.walking.lesson17_enum.task1;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * через enum. В т.ч. реализуйте в enum'е поиск значения по фразе,
 * введенной пользователем. Напоминаю, что enum'ы могут содержать поля.
 */
public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String message = requireMessage();

        Answer[] answers = Answer.values();

        System.out.println(Answer.getAnswer(answers, message));

    }

    public static String requireMessage() {
        return scanner.nextLine();
    }
}
