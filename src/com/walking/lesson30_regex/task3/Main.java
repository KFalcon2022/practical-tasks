package com.walking.lesson30_regex.task3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String[] words = scanner.nextLine()
                .trim()
                .toLowerCase()
                .split("\\s+");

        scanner.close();

        isCorrectWord(words);

        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            boolean isUnique = true;
            while (j < i && isUnique) {
                if (words[i].equals(words[j])) {
                    isUnique = false;
                } else {
                    j++;
                }
            }

            if (isUnique) {
                counter++;
            }
        }

        System.out.printf("Found %d unique words\n", counter);
    }

    public static boolean isCorrectWord(String[] words) throws InvalidSymbolException {
        Pattern pattern = Pattern.compile("^[a-zA-ZÀ-ßà-ÿ¨¸]+(-[a-zA-ZÀ-ßà-ÿ¨¸]+)*$");

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);

            if (!matcher.matches()) {
                throw new InvalidSymbolException();
            }
        }

        return true;
    }
}