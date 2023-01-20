package com.walking.lesson16_abstract_class_interface.task1_abstract_class.validators;

public class LengthValidator {
    public LengthValidator(int length) throws Exception {
        if (length < 1 || length > 10) {
            throw new Exception("Длинна слишком большая");
        }
    }
}
