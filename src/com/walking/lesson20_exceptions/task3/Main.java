package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exception.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.animal.Animal;
import com.walking.lesson20_exceptions.task3.animal.Cat;
import com.walking.lesson20_exceptions.task3.animal.Cow;
import com.walking.lesson20_exceptions.task3.animal.Dog;

/**
 * Реализуйте любой из вариантов задачи в уроке 18.
 * Для ситуации, когда тип животного неизвестен, выбрасывайте собственное исключение UnknownAnimalException.
 * Предка исключения определите самостоятельно.
 * <p>
 * Также предусмотрите валидацию массива животных на содержание пустых элементов.
 * Если таковые существуют – бросьте кастомное исключение ArrayValidationException,
 * которое содержит информацию об индексе массива, содержащем null.
 */
public class Main {
    public static void main(String[] args) throws ArrayValidationException, UnknownAnimalException {
        Animal[] animals = new Animal[]{new Cat(), new Cow(), new Dog(), new Cow(), new Animal(""), null};
        for (int i = 0; i < animals.length; i++) {
            if (!isValid(animals[i])) {
                throw new ArrayValidationException("Object is expected at index: " + i);
            }

            switch (animals[i]) {
                case Cat cat -> cat.meow();
                case Dog dog -> dog.woof();
                case Cow cow -> cow.moo();
                case null, default -> throw new UnknownAnimalException("Unknown animal");
            }
        }
    }

    public static boolean isValid(Animal animal) {
        return animal != null;
    }
}
