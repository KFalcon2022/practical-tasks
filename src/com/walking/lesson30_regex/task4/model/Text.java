package com.walking.lesson30_regex.task4.model;

import java.util.StringJoiner;

public class Text {
    private static final String PARAGRAPH_REGEX = "\n";
    private static final String PARAGRAPH_DELIMITER = "\n";
    private final String content;
    private final Paragraph[] paragraphs;

    public Text(String rawText) {
        this.content = rawText;
        this.paragraphs = textToParagraph(rawText);
    }

    private static Paragraph[] textToParagraph(String rawText) {
        String[] rawParagraphs = rawText.split(PARAGRAPH_REGEX);

        Paragraph[] paragraphs = new Paragraph[rawParagraphs.length];

        for (int i = 0; i < paragraphs.length; i++) {
            paragraphs[i] = new Paragraph(rawParagraphs[i]);
        }

        return paragraphs;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(PARAGRAPH_DELIMITER);

        for (Paragraph paragraph : paragraphs) {
            stringJoiner.add(paragraph.toString());
        }

        return stringJoiner.toString();
    }
}