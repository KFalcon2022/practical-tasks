package com.walking.lesson41_set.task2.service;

import java.util.HashSet;
import java.util.List;

public class SetUniqWordCounter {
    private static HashSet<String> wordsSet = new HashSet<>();
    private static final String REGEX_DIVIDER = "\\s+";
    public static int countWords(String sentence){
        String[] words = sentence.trim().toLowerCase().split(REGEX_DIVIDER);
            wordsSet.addAll(List.of(words));
        return wordsSet.size();
    }
}
