package com.walking.lesson3_casts_conditional_constructions;

import java.util.Scanner;

/**
 * Завести три переменные типа String.
 * С клавиатуры ввести в них вашу фамилию, имя и отчество.
 * Вывести в консоль в одну строку ваше ФИО.
 * Сделать, используя System.out.printf
 */
public class Task3Printf {
    public static void main(String[] args) {
//        Создаем сканер для чтения с клавиатуры
        Scanner scanner = new Scanner(System.in);

//        Выводим сообщение "Enter first name: " в консоль.
//        Данное сообщение не является обязательным, лишь информирует пользователя,
//        какое действие от него ожидается
        System.out.print("Enter first name: ");
//        Объявляем переменную s типа String и записываем в нее значение, введенное с клавиатуры
        String firstName = scanner.nextLine();

//        Производим аналогичные действия для фамилии и отчества
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter patronymic: ");
        String patronymic = scanner.nextLine();

//        Сканер более не используется, ее необходимо закрыть.
        scanner.close();

//        Выводим в консоль ФИО, не забывая о пробелах
        System.out.printf("%s %s %s", lastName, firstName, patronymic);
    }

    /*
     * Примечание. Конкретно в этом примере мы ввели сначала имя, потом фамилию.
     * Однако вывод сделан в обратном порядке: фамилия, потом имя
     *
     * Странно просить сначала last name, позже first name,
     * других объективных причин так делать нет:)
     */
}
