package com.walking.lesson30_regex.task4.exception;

public class RegexValidationException extends RuntimeException {
    public RegexValidationException(String str, String regex) {
        super("%s not matches to '%s'".formatted(str, regex));
    }
}
