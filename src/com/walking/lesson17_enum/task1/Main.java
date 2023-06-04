package com.walking.lesson17_enum.task1;

import com.walking.lesson17_enum.task1.enums.Answers;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * через enum. В т.ч. реализуйте в enum'е поиск значения по фразе,
 * введенной пользователем. Напоминаю, что enum'ы могут содержать поля.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---lesson17_enum.task1---");
        System.out.print("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        String res = Answers.getAnswer(s);

        System.out.println(res);

    }
}
