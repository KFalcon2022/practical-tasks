package com.walking.lesson26_string_types.task2;

import com.walking.lesson26_string_types.task2.service.UniqWordCounter;

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
        Scanner scannerIn = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String inputString = scannerIn.nextLine();
        int number = new UniqWordCounter(inputString).findUniqWords();
        System.out.println("Amount of unique words in the sentence: "+number);
    }
}
