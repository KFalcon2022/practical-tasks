package com.walking.lesson30_regex.task4.service;

import com.walking.lesson30_regex.task4.exception.RegexValidationException;

public class ValidationService {
    //    В целом, можно дальше расширять список недопустимого использования различных комбинаций символов
    public static final String ALLOWED_SYMBOLS_REGEX = ".*[^\nA-Za-z0-9.?!,:'-].*";
    public static final String ALLOWED_PUNCTUATION_REGEX = ".+[\n ?,:-]{2,}.+";
    public static final String ALLOWED_EXCLAMATION_REGEX = ".+!{2,}.+";
    public static final String INCORRECT_EXCLAMATION_QUESTION_REGEX = ".+!?.+";
    public static final String INCORRECT_PUNCTUATION_PARAGRAPH_USING_REGEX = ".+\n\\W.+";
    public static final String INCORRECT_PUNCTUATION_FIRST_PARAGRAPH_USING_REGEX = "^\\W.+";
    public static final String INCORRECT_SENTENCE_BEGIN_REGEX = ".+[.?!]+[^A-Z0-9].+";

    public void validate(String text) {
        if (text.matches(ALLOWED_SYMBOLS_REGEX)) {
            throw new RegexValidationException(text, ALLOWED_SYMBOLS_REGEX);
        }
        if (text.matches(ALLOWED_PUNCTUATION_REGEX)) {
            throw new RegexValidationException(text, ALLOWED_PUNCTUATION_REGEX);
        }
        if (text.matches(ALLOWED_EXCLAMATION_REGEX)) {
            throw new RegexValidationException(text, ALLOWED_EXCLAMATION_REGEX);
        }
        if (text.matches(INCORRECT_EXCLAMATION_QUESTION_REGEX)) {
            throw new RegexValidationException(text, INCORRECT_EXCLAMATION_QUESTION_REGEX);
        }
        if (text.matches(INCORRECT_PUNCTUATION_PARAGRAPH_USING_REGEX)) {
            throw new RegexValidationException(text, INCORRECT_PUNCTUATION_PARAGRAPH_USING_REGEX);
        }
        if (text.matches(INCORRECT_PUNCTUATION_FIRST_PARAGRAPH_USING_REGEX)) {
            throw new RegexValidationException(text, INCORRECT_PUNCTUATION_FIRST_PARAGRAPH_USING_REGEX);
        }
        if (text.matches(INCORRECT_SENTENCE_BEGIN_REGEX)) {
            throw new RegexValidationException(text, INCORRECT_SENTENCE_BEGIN_REGEX);
        }
    }
}
