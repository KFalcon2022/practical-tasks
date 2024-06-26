package com.walking.lesson16_abstract_class_interface.task2;

import java.util.Scanner;

import com.walking.lesson16_abstract_class_interface.task2.model.Greetings;
import com.walking.lesson16_abstract_class_interface.task2.model.ISender;
import com.walking.lesson16_abstract_class_interface.task2.model.Parting;
import com.walking.lesson16_abstract_class_interface.task2.model.SmallTalk;

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        scanner.close();
        ISender receive=null;
        switch (s) {
            case "Hi":
                receive=new Greetings();
                break;

            case "Bye":
                receive=new Parting();
                break;

            case "How are you":
                receive=new SmallTalk();
                break;

            default:
                System.out.println("Unknown message");
        }
        if (receive!=null)
            System.out.println(receive.answer());
    }
}
