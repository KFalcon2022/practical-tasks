package com.walking.lesson17_enum.task3.validators;

public class LengthValidator {
    public boolean validate(int length) {
        return 1 < length & length < 10;
    }
}
