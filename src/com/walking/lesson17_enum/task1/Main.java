package com.walking.lesson17_enum.task1;

import com.walking.lesson17_enum.task1.enums.Greeting;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * через enum. В т.ч. реализуйте в enum'е поиск значения по фразе,
 * введенной пользователем. Напоминаю, что enum'ы могут содержать поля.

 *  Написать программу, которая принимает строку с клавиатуры.
 *  * Если строка == "Hi" - вывести в консоль "Hello",
 *  * если Bye - Good bye,
 *  * если How are you - How are your doing.
 *  * Если любая другая строка - вывести Unknown message.
 *  * Сделать через switch-case
 */
public class Main {
    public static void main(String[] args) {

        Scanner io = new Scanner(System.in);
        System.out.println("Enter something. ");
        String userInput = io.nextLine();
        io.close();

        Greeting outPut = Greeting.findGreeting(userInput);
        System.out.println(outPut.getReturnGreeting());

    }

}
