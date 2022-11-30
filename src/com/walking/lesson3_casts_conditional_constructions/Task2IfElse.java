package com.walking.lesson3_casts_conditional_constructions;

import java.util.Scanner;

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через if-else
 */
public class Task2IfElse {
    public static void main(String[] args) {
//        Создаем сканер для чтения с клавиатуры
        Scanner scanner = new Scanner(System.in);

//        Выводим сообщение "Enter string: " в консоль.
//        Данное сообщение не является обязательным, лишь информирует пользователя,
//        какое действие от него ожидается
        System.out.print("Enter string: ");
//        Объявляем переменную s типа String и записываем в нее значение, введенное с клавиатуры
        String s = scanner.nextLine();

//        Сканер более не используется, ее необходимо закрыть.
//        Зачем - разберемся, когда будем изучать I/O Streams
        scanner.close();

        if ("Hi".equals(s)) {   // Если значение s совпадает с "Hi"
//            Выводим в консоль "Hello"
            System.out.println("Hello");
        } else if ("Bye".equals(s)) {   // Если значение s не равно "Hi", но равно "Bye"
            System.out.println("Good bye");
        } else if ("How are you".equals(s)) {
            System.out.println("How are your doing");
        } else {    // Во всех иных случаях
            System.out.println("Unknown message");
        }
    }
}
