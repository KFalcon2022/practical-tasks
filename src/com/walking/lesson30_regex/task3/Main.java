package com.walking.lesson30_regex.task3;

import com.walking.lesson30_regex.task3.service.WordValidationService;

import java.util.Scanner;

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
 */
public class Main {
    public static void main(String[] args) {
        String testWords1 = "    ноль    00 один11 ОДИН 2  2ва  два ТрИ -три- Че-ты-ре Пя--ть 5ть      ";
        String testWords2 = "пять четыре три один два три четыре-пять";
        String testWords3 = "один два один четыре-пять six";
        String testWords4 = "one two three four-five";
        String testWords5 = "один two один four-пять";


        int amountUniqueWordsInString = WordValidationService.countUniqueWords(testWords2);

        System.out.printf("Количество уникальных слов в строке: %d\n", amountUniqueWordsInString);
    }

    public static String getStringFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку, содержащую слова, разделенные пробелом.");

        String input = scanner.nextLine();

        scanner.close();

        return input;
    }
}
