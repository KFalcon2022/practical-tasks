package com.walking.lesson20_exceptions.task3.validation;

import com.walking.lesson20_exceptions.task3.exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.model.Animal;

public class ValidationAnimals {
    public static void validation(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            if (animal == null) {
                throw new ArrayValidationException("Нулевое значение в элементе: ", i);
            }
        }
    }
}
