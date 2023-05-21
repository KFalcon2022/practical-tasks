package com.walking.lesson26_string_types.task2;

/**
 * Реализуйте программу, принимающую с клавиатуры строку,
 * содержащую слова, разделенные пробелом.
 * Выведите в консоль количество уникальных слов в строке.
 * Учтите, что строка может начинаться с пробела.
 * <p>
 * Для упрощения допустим, что в строке не могут использоваться символы,
 * отличные от пробела или русских/английский букв.
 * Помните, что слово может быть введено в разных регистрах.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string:");
        String input = scanner.nextLine();
        scanner.close();

        String[] strings = input.split("\s");

        for (int i=0; i < strings.length; i++ ) {
            if (strings[i].isBlank()){
                continue;
            }
            int count = 1;

            for (int j = i + 1; j < strings.length; j++){
                if (strings[i].toLowerCase().equals(strings[j].toLowerCase())){
                  strings[j] = "";
                  count++;
                }
            }

            System.out.printf("%s = %d\n", strings[i], count);

        }

    }

}
