package com.walking.lesson17_enum.task3.validators;

public class LengthValidator {
    private int length;

    public LengthValidator(int length) {
        this.length = length;
    }

    public boolean validate() {
        return 1 < this.length & this.length < 10;
    }
}
