package com.walking.lesson30_regex.task4.model;

import java.util.StringJoiner;

public class Sentence {
    private static final String WORD_REGEX = "(, )|(: )|( - )";
    private static final String WORD_DELIMITER = " ";
    private final String content;
    private final String[] words;

    public Sentence(String content) {
        this.content = content;
        this.words = sentenceToWord(content);
    }

    private static String[] sentenceToWord(String content) {
        return content.split(WORD_REGEX);
    }

    @Override
    public String toString() {
        StringJoiner wordsToSentence = new StringJoiner(WORD_DELIMITER);

        for (String word : words) {
            wordsToSentence.add(word);
        }

        return wordsToSentence.toString();
    }
}
