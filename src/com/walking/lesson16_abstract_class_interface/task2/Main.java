package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.Bye;
import com.walking.lesson16_abstract_class_interface.task2.model.Greeting;
import com.walking.lesson16_abstract_class_interface.task2.model.Hi;
import com.walking.lesson16_abstract_class_interface.task2.model.UnknownGreeting;

import java.util.Locale;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {

    static final String REQUEST_HI = "hi";
    static final String REQUEST_BYE = "bye";
    public static void main(String[] args) {
        System.out.println("Enter your greeting");

        Scanner io = new Scanner(System.in);
        String userEntry = io.nextLine();
        io.close();

        Greeting reply;

        switch (userEntry.toLowerCase(Locale.ROOT)){
            case REQUEST_HI -> reply = new Hi();
            case REQUEST_BYE -> reply = new Bye();
            default -> reply = new UnknownGreeting();
        }
        System.out.println(reply.printReply());

    }
}
