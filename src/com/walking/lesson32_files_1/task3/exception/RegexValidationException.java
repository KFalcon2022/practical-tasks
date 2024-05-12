package com.walking.lesson32_files_1.task3.exception;

public class RegexValidationException extends RuntimeException {
    public RegexValidationException(String message, String phrase, String regex) {
        super("%s %s not matches to '%s'".formatted(message, phrase, regex));
    }
}
