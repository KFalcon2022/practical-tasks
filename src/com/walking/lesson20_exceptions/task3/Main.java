package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exceptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exceptions.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.animals.Animal;
import com.walking.lesson20_exceptions.task3.animals.Cat;
import com.walking.lesson20_exceptions.task3.animals.Cow;
import com.walking.lesson20_exceptions.task3.animals.Dog;

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
        sound(animals);
    }

    public static void sound(Animal[] animals) throws ArrayValidationException, UnknownAnimalException {
        for (int i = 0; i < animals.length; i++) {
            if (!isValid(animals[i])) {
                throw new ArrayValidationException("Object is expected at index: " + i);
            }

            if (animals[i] instanceof Cat cat) {
                cat.meow();
            } else if (animals[i] instanceof Dog dog) {
                dog.woof();
            } else if (animals[i] instanceof Cow cow) {
                cow.moo();
            } else {
                throw new UnknownAnimalException("Unknown animal");
            }
        }
    }

    public static boolean isValid(Animal animal) {
        return animal != null;
    }
}
