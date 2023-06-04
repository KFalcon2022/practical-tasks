package com.walking.lesson20_exceptions.task2;

import com.walking.lesson16_abstract_class_interface.task2.model.Bye;
import com.walking.lesson16_abstract_class_interface.task2.model.Hi;
import com.walking.lesson16_abstract_class_interface.task2.model.HowAreYou;

import java.util.Scanner;

/**
 * Реализуйте любой из вариантов Задачи 1 в уроке 16.
 * При некорректном вводе с клавиатуры выбрасывайте собственное исключение InputValidationException.
 * Не забудьте указать в описании, какой именно из вводов был некорректен -
 * message исключения должен быть информативным.
 * Предка исключения определите самостоятельно.
 */
public class Main {
    public static void main(String[] args) throws InputValidationException {
        System.out.print("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        switch (s) {
            case "Hi":
                s = new Hi().getAnswer();
                break;

            case "Bye":
                s = new Bye().getAnswer();
                break;

            case "How are you":
                s = new HowAreYou().getAnswer();
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                throw new InputValidationException("Unknown message");

        }
        System.out.println(s);
    }
}
