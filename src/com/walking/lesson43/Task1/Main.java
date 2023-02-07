package com.walking.lesson43.Task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String[] words = scanner.nextLine()
                .trim()
                .toLowerCase().split("[^\\w]+");

        Map<String, Integer> wordsCounter = new HashMap<>();
        for (String word : words) {
            wordsCounter.put(word, wordsCounter.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry entry : wordsCounter.entrySet()) {
            System.out.printf("Word: %s, counter: %d\n", entry.getKey(), entry.getValue() );
        }
    }
}