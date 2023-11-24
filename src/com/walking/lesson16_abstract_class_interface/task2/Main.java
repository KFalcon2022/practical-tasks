package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.*;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {

    static final String REQUEST_HI = "Hi";
    static final String REQUEST_BYE = "Bye";
    static final String REQUEST_HOW_ARE_YOU = "How are you";
    public static void main(String[] args) {
        System.out.println("Enter your greeting");

        Scanner io = new Scanner(System.in);
        String userEntry = io.nextLine();
        io.close();

        Greeting reply;

        switch (userEntry){
            case REQUEST_HI -> reply = new Hi();
            case REQUEST_BYE -> reply = new Bye();
            case REQUEST_HOW_ARE_YOU -> reply = new HowAreYou();
            default -> reply = new UnknownGreeting();
        }
        System.out.println(reply.printReply());

    }
}
