package com.walking.lesson17_enum.task1;

import com.walking.lesson16_abstract_class_interface.task2.model.AskMessage;
import com.walking.lesson16_abstract_class_interface.task2.model.ByeMessage;
import com.walking.lesson16_abstract_class_interface.task2.model.HelloMessage;
import com.walking.lesson16_abstract_class_interface.task2.model.UnknownMessage;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * через enum. В т.ч. реализуйте в enum'е поиск значения по фразе,
 * введенной пользователем. Напоминаю, что enum'ы могут содержать поля.
 */

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String inputMessage = scanner.nextLine();

        scanner.close();

        Message message = Message.findMessage(inputMessage);
        System.out.println(message.getRequiredMessage());
    }
}
