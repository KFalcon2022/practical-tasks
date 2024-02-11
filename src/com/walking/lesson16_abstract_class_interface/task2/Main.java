package com.walking.lesson16_abstract_class_interface.task2;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через switch-case
 */
public class Main {
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("Enter your sentence: ");
        String inputAnswer = scannerIn.nextLine();
        checkAnswer(inputAnswer);


        scannerIn.close();

    }
    private static void checkAnswer(String answer){
        switch (answer){
            case "Hi":
                new Answer().hiAnswer();
                break;
            case "Bye":
                new Answer().byeAnswer();
                break;
            case "How are you":
                new Answer().howAreYouAnswer();
                break;
            default:
                new Answer().unknownAnswer();
                break;
        }
    }
}
