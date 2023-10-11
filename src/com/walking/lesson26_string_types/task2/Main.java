package com.walking.lesson26_string_types.task2;

import java.util.Scanner;

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
public class Main {
    public static void main(String[] args) {
        System.out.println("Введи слова через пробел: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        str.trim();
        String[] strArr = str.split(" ");

        int uniqueWords = 0;

        for (int i = 0; i < strArr.length; i++) {
            boolean isUni = true;
            int j = 0;
            while (j < i && isUni) {
                if (strArr[i].equals(strArr[j])) {
                    isUni = false;
                } else {
                    j++;
                }

            }

            if (isUni) {
                uniqueWords++;
            }
        }
        System.out.println(uniqueWords);
    }
}
