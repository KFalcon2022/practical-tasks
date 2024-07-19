package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exception.UnknownAnimalException;
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
        Animal[] animals = createAnimalsArray();

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (Animal animal : animals) {
            sound(animal);
        }
    }

    private static void sound(Animal animal) {
        if (animal.getClass().equals(Cat.class)) {
            ((Cat) animal).meow();
        } else if (animal.getClass().equals(Dog.class)) {
            ((Dog) animal).woof();
        } else if (animal.getClass().equals(Cow.class)) {
            ((Cow) animal).moo();
        } else {
            throw new UnknownAnimalException("unable use animal this class ='" + animal.getClass() + "\'");
        }
    }

    public static Animal[] createAnimalsArray() {
        Animal[] animals = new Animal[5];

        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cow();
        animals[3] = new Animal("chik-chirik");
        animals[4] = null;

        for (int i = 0; i < animals.length; i++) {
            if (null == animals[i]) {
                throw new ArrayValidationException("array Animal[" + i + "] contains null");
            }
        }

        return animals;
    }
}
