package com.walking.lesson17_enum.task1;

import com.walking.lesson17_enum.task1.model.Message;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * через enum. В т.ч. реализуйте в enum'е поиск значения по фразе,
 * введенной пользователем. Напоминаю, что enum'ы могут содержать поля.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter string: ");
        String messageUser = in.nextLine();

        Message message = Message.findAnswer(messageUser);
        System.out.println(message.getAnswer());

        in.close();
    }
}
