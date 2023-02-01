package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exceptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exceptions.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.model.Animal;
import com.walking.lesson20_exceptions.task3.model.Cat;
import com.walking.lesson20_exceptions.task3.model.Cow;
import com.walking.lesson20_exceptions.task3.model.Dog;

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
        Animal[] animals = new Animal[]{new Cat(), new Dog(),  null};
        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal == null) {
                throw new ArrayValidationException("Invalid value in array");
            }
            sound(animal);
        }
    }

    private static void sound(Animal animal) {
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.meow();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.woof();
        } else {
            throw new UnknownAnimalException(String.format("Unsupported class %s", animal.getClass().getName()));
        }
    }
}
