package com.walking.lesson3;

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через switch-case
 */

import java.util.Scanner;

public class Task2SwitchCase {
    public static void main(String[] args) {
        System.out.println("Write something");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        Printable output;

        switch (input.toLowerCase()){
            case "hi":{
                output = new Hello();
                break;
            }
            case "bye":{
                output = new Goodbye();
                break;
            }
            case "how are you": {
                output = new HowAreYouDoing();
                break;
            }
            default:{
                output = new PrintableMessage();
            }
        }
        System.out.println(output.print());
    }
}
