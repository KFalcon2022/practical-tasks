package com.walking.lesson3_casts_conditional_constructions;

/**
 * Завести три переменные типа String.
 * С клавиатуры ввести в них вашу фамилию, имя и отчество.
 * Вывести в консоль в одну строку ваше ФИО.
 * Сделать, используя System.out.printf
 */
public class Task3Printf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Фамилия: ");
        String surname = scanner.nextLine();

        System.out.print("имя: ");
        String name = scanner.nextLine();

        System.out.print("Отчество: ");
        String fathername = scanner.nextLine();

        scanner.close();

        System.out.println("Полное имя:");
        System.out.printf("%s %s %s", surname, name, fathername);
    }
}
