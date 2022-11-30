package com.walking.lesson16_abstract_class_interface.task2;

import src.com.walking.lesson16_abstract_class_interface.task2.ComeBack;

import java.util.Scanner;

/**
переделал с использванием интерфейса.
 у него - константы, стринг
 у него - 1 статический метод
 я не делал класс и наследование от интерфеса для упрощения программы, меньше кода.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        scanner.close();

        //запрашиваем на вывод статический метод из интерфейса.
        System.out.println(ComeBack.saySomething(s));

    }
}