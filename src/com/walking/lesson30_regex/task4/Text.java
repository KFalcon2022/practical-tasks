package com.walking.lesson30_regex.task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private String text;
    private String[] words;
    private StringBuilder newText = new StringBuilder();
    private int[] dotsNumbers = new int[0];
    private int[] paragraphNumbers = new int[0];

    public String[] getWords() {
        return words;
    }

    public StringBuilder getNewText() {
        return newText;
    }

    public Text(String text) {
        this.text = text;
    }

    int[] increaseArray(int[] array, int x) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[array.length] = x;

        return newArray;
    }

    public void countDotNumbers() {
        Pattern dotsPattern = Pattern.compile("\\.");
        Matcher dotsMatcher = dotsPattern.matcher(text);

        while (dotsMatcher.find()) {
            dotsNumbers = increaseArray(dotsNumbers, dotsMatcher.end());
        }
    }

    public void countParagraphNumbers() {
        Pattern paragraphPattern = Pattern.compile("\n");
        Matcher paragraphMatcher = paragraphPattern.matcher(text);

        while (paragraphMatcher.find()) {
            paragraphNumbers = increaseArray(paragraphNumbers, paragraphMatcher.end());
        }
    }

    public void replacePunctuationMarks() {
        text = text.replaceAll("[!+\\?+]", "\\.");
        text = text.replaceAll("\\.+", "\\.");
        text = text.replaceAll("[\"\\-,:;]", " ");
        text = text.replaceAll("\\s{2,}", " ");
    }

    public void splitTextIntoWords() {
        replacePunctuationMarks();
        countDotNumbers();
        countParagraphNumbers();

        words = text.split("[\\.\\s]+");
    }

    public void collectText() {
        for (String word : words) {
            newText.append(word + " ");
        }

        for (int number : dotsNumbers) {
            for (int i = 0; i < (newText.length() + paragraphNumbers.length + dotsNumbers.length); i++) {
                if (number == i) {
                    newText.insert(number - 1, ".");
                }
            }
        }

        for (int number : paragraphNumbers) {
            for (int i = 0; i < (newText.length() + paragraphNumbers.length + dotsNumbers.length); i++) {
                if (number == i) {
                    newText.insert(number - 1, "\n");
                    newText.delete(number, number + 1);
                    //newText.replace(number, number, "\n");
                }
            }
        }
    }
}
