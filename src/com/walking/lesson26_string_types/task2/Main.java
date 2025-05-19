package com.walking.lesson26_string_types.task2;

import java.util.Scanner;

/**
 * Реализуйте программу, принимающую с клавиатуры строку,
 * содержащую слова, разделенные пробелом.
 * Выведите в консоль количество уникальных слов в строке.
 * Учтите, что строка может начинаться с пробела.
 * <p>
 * Пример:
 * <p>
 * <code>Мама мыла раму мама рамы мыла. Пример строки</code>
 * <p>
 * В данном случае будем считать, что уникальных слов 6: мама, мыла, раму, рамы, пример, строки.
 * <p>
 * Для упрощения допустим, что в строке не могут использоваться символы,
 * отличные от пробела или русских/английский букв.
 * Помните, что слово может быть введено в разных регистрах.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a words: ");
        StringBuffer strings = new StringBuffer(scanner.nextLine().trim());

        scanner.close();

        String[] array = strings.toString().split(" ");
        System.out.println("ИЛИ ЖЕ ПРОЩЕ СОЗДАТЬ МАССИВ STRINGBUILDER И ЗНАЧЕНИЕ КАЖДОГО МАССИВА ПРИВОДИТЬ К СТРОКЕ??" +
                "ОТВЕТЬ ПЖ В КОМЕНТАРИЯХ К ПР)");

        int wordsCounter = getWordsCounter(array);

        System.out.println(wordsCounter);
    }

    private static int getWordsCounter(String[] array) {
        int wordsCounter = 0;

        for (int i = 0; i < array.length; i++) {

            if (i == 0) {
                wordsCounter++;
                continue;
            }
            if (array[i].isBlank()) {
                continue;
            }

            for (int j = 0; j < i; j++) {

                if (array[i].compareToIgnoreCase(array[j]) == 0) {
                    break;
                } else if (j < i - 1) {
                    continue;
                } else {
                    wordsCounter++;
                }
            }
        }
        return wordsCounter;
    }
}
