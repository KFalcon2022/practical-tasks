package com.walking.lesson16_abstract_class_interface.task2;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * с использованием интерфейсов. Каждая реализация должна возвращать свое сообщение.
 */

import com.walking.lesson16_abstract_class_interface.task2.model.*;

import java.util.Scanner;
public class Main {
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
        IPrintOut printout;
        switch (s) {
            case "Hi":  // Если s равно "Hi"
                printout = new Hi();
                break;

            case "Bye":
                printout = new Bye();
                break;

            case "How are you":
                printout = new HowAreYou();
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                printout = new Unknown();
                ;
        }

        System.out.println(printout.output());
    }
}
