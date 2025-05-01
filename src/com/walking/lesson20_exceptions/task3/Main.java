package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.model.*;

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
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cow(), new Cat(), new Dog(), new bee() };

        try {
            soundAll(animals);
        } catch (UnknownAnimalException | ArrayValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void soundAll(Animal[] animals) throws UnknownAnimalException, ArrayValidationException {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                throw new ArrayValidationException("Index " + i + " is null");
            }

            sound(animals[i]);
        }
    }

    private static void sound(Animal animal) throws UnknownAnimalException {
        if (animal instanceof Cat cat) {
            cat.meow();
        } else if (animal instanceof Dog dog) {
            dog.woof();
        } else if (animal instanceof Cow cow) {
            cow.moo();
        } else {
            throw new UnknownAnimalException("Unknown animal");
        }
    }
}
