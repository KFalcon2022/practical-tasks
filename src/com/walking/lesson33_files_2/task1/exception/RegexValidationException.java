package com.walking.lesson33_files_2.task1.exception;

public class RegexValidationException extends RuntimeException {
    public RegexValidationException(String message, String phrase, String regex) {
        super("%s %s not matches to '%s'".formatted(message, phrase, regex));
    }
}
