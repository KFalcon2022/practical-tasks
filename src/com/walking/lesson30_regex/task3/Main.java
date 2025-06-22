package com.walking.lesson30_regex.task3;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson26_string_types/task2/Main.java">...</a>
 * Теперь слова в исходном массиве могут быть разделены несколькими пробелами,
 * а также знаками табуляции и иными пробельными символами.
 * Словами считаются лишь подстроки,
 * состоящие из буквенных символов или содержащие в середине слова один
 * или несколько дефисов, но не более одного подряд.
 * При наличии в исходной строке невалидных символов или некорректном использовании допустимых,
 * должно быть выброшено исключение.
 * <p> </p>
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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String[] words = scanner.nextLine()
                .trim()
                .toLowerCase()
                .split("\\s+|(\\s)+");

        scanner.close();

        int counter = 0;

        for (int i = 0; i < words.length; i++) {
            // Каждое слово в массиве сравниваем с предыдущими словами того же массива.
            // Если слово эквивалентно одному из предыдущих - оно не уникально
            int j = 0;
            boolean isUnique = true;

            if (words[i].matches("\\w+[^0-9]+")) {
                throw new RuntimeException("Have invalid symbol");
            }


            if (words[i].contains("-")) {
                if (!words[i].matches("[^-]+-?[^-]+-?[^-]+")) {
                    throw new RuntimeException("More than 1 hyphens");
                }
            }

            while (j < i && isUnique) {
                if (words[i].equals(words[j])) {
                    isUnique = false;
                } else {
                    j++;
                }
            }

            System.out.println(words[i]);
            if (isUnique) {
                counter++;
            }
        }

        System.out.printf("Found %d unique words", counter);
    }
}

