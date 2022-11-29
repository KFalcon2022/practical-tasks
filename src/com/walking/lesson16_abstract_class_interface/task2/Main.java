package com.walking.lesson16_abstract_class_interface.task2;

import java.util.Scanner;

/**
 * Написать программу, которая принимает строку с клавиатуры.
 * Если строка == "Hi" - вывести в консоль "Hello",
 * если Bye - Good bye,
 * если How are you - How are your doing.
 * Если любая другая строка - вывести Unknown message.
 * Сделать через switch-case
 */
public class Main implements output {
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

//        Используем конструкцию switch-case для переменной s
        switch (s) {
            case "Hi":  // Если s равно "Hi"
//                Выводим в консоль "Hello"
                print("Hello");
//                Вызываем оператор break, чтобы выйти из switch-case
                break;

            case "Bye":
                print("Good bye");
                break;

            case "How are you":
                print("How are your doing");
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                print("Unknown message");
        }
    }

    public static void print(String string){
        System.out.println(string);
    }
}

interface output{
    default void print(){
        System.out.println("Unknown message!");
    }
}