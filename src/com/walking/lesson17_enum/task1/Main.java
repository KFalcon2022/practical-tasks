package com.walking.lesson17.task1;

import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson3/Task2SwitchCase.java">...</a>
 * через enum. В т.ч. реализуйте в enum'е поиск значения по фразе,
 * введенной пользователем. Напоминаю, что enum'ы могут содержать поля.
 */
public class Main {

    public static void main(String[] args) {
//        Создаем сканер для чтения с клавиатуры
        Scanner scanner = new Scanner(System.in);
//        Выводим сообщение "Enter string: " в консоль.
        
        System.out.print("Enter string: ");
//        Объявляем переменную s типа String и записываем в нее значение, введенное с клавиатуры
        String s = scanner.nextLine();

        PHRASE phrase = PHRASE.valueOf(s); //создаем объект Enum и вызывает метод для проверки введенного с клавиатуры (т.е. поиск по полю элементов Enum)

        scanner.close();

//        Используем конструкцию switch-case для переменной s
       switch (phrase) {
           case Hi:  // Если s равно "Hi"
//                Выводим в консоль "Hello"
                System.out.println("Hello");
                break;

           case Bye: // Если s равно "Bye"
                System.out.println("Good bye");
                break;

           case Howareyou:// Если s равно "Howareyou"
                System.out.println("How are your doing");
                break;

            default:  // Если значение s не совпадает ни с одним кейсом
                System.out.println("Unknown message");
        }
    }
}
