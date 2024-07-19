package com.walking.lesson30_regex.task4.model;

import java.util.StringJoiner;

public class Paragraph {
    private static final String SENTENCE_REGEX = "(\\.\\.\\.)|(\\?!)|([.!?])";
    private static final String SENTENCE_DELIMITER = ".";
    private static final String SENTENCE_SUFFIX = ".";
    private final String content;
    private final Sentence[] sentences;

    public Paragraph(String content) {
        this.content = content;
        this.sentences = contentToSentence(content);
    }

    private static Sentence[] contentToSentence(String content) {
        String[] rawSentence = content.split(SENTENCE_REGEX);

        Sentence[] sentences = new Sentence[rawSentence.length];

        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = new Sentence(rawSentence[i]);
        }

        return sentences;
    }

    @Override
    public String toString() {
        StringJoiner sentenceToParagraph = new StringJoiner(SENTENCE_DELIMITER, "", SENTENCE_SUFFIX);

        for (Sentence sentence : sentences) {
            sentenceToParagraph.add(sentence.toString());
        }

        return sentenceToParagraph.toString();
    }
}