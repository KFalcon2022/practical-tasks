package com.walking.lesson16_abstract_class_interface.task2;

import com.walking.lesson16_abstract_class_interface.task2.Answears.*;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter string: ");
        Scanner sc = new Scanner(System.in);
        String questionType = sc.nextLine().toLowerCase();
        System.out.println(question(questionType));

    }

    private static String question(String questionType){
        switch (questionType){
            case "hi":
                return new Hi().answear();
            case "how are you":
                return new HowAreYou().answear();
            case "bye":
                return new Bye().answear();
            default:
                return "Dude, I dont understand you!";

        }
    }
}