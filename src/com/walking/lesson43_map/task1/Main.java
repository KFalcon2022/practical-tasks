package com.walking.lesson43_map.task1;

import com.walking.lesson43_map.task1.service.UniqueWordsCounter;

import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого из уникальных слов
 * во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 */

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
        Scanner scannerIn = new Scanner(System.in);
        String inputText = getTextString(scannerIn);
        scannerIn.close();

        UniqueWordsCounter uniqWordsService = new UniqueWordsCounter(inputText);
        System.out.println(uniqWordsService);
    }
    private static String getTextString(Scanner scannerIn){
        System.out.print("Enter your text: ");
        return scannerIn.nextLine();
    }
}
