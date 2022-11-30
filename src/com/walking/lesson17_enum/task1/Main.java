package com.walking.lesson17_enum.task1;

import src.com.walking.lesson17_enum.task1.Answers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = scanner.nextLine();
        scanner.close();

        //тут у нас ENUM ищет ответ на текст пользователя, использую статический метод.

        System.out.println(Answers.talkBack(s));

    }
}