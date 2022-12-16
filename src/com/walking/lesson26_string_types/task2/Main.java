package com.walking.lesson26_string_types.task2;

import java.util.Scanner;

/**
 * задача принимать с клавиатуры строку со словами, нужно посчитать количество уникальных слов;
 * программа отлавливает двойной пробел, четко видит уникальные слова, но итоговое количество слов считает приблизительно :D
 * пользователь не имеет право молчать, программа требует разговор иначе format C://
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Скажите несколько слов для анализа");
        String answer = null;

        do {
            answer = scanner.nextLine();
            if (answer.isBlank()) {
                System.err.println("Вы не сказали ничего, давай, не молчи.");
            }
        } while (answer.isBlank());

        //удалим лишние пробелы если были
        answer = answer.strip();


        //создаем массив из слов которые передал пользователь строкой
        String[] words = answer.split(" ");

        //запускаем статический метод, который вернет число уникальных слов
        int uniq = checkUniq(words);

        System.out.println("Всего слов: " + words.length + "\nВсего уникальных слов: " + uniq);
    }

    public static int checkUniq(String[] array) {
        int result = array.length;
        int repeat = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareToIgnoreCase(array[j]) == 0) {
                    repeat++;
                    break;
                } else if (array[i].isBlank()) {
                    repeat++;
                }
            }
        }

        return result - repeat;
    }
}


