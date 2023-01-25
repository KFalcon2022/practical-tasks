package com.walking.lesson16_abstract_class_interface.task1_abstract_class.validators;

public class LengthValidator {
    private int length;

    public LengthValidator(int length) {
        this.length = length;
    }

    public boolean validate() {
        return 1 < this.length & this.length < 10;
    }
}
