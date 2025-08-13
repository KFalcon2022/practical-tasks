package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exception.UnknownAnimalException;
import com.walking.lesson20_exceptions.task3.model.*;

import java.util.Arrays;

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
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null};

        for (Animal member : animals) {
            if (member == null) {
                throw new ArrayValidationException("Null in array index: %d".formatted(Arrays.asList(animals).indexOf(member)));
            }
            sound(member);
        }
    }

// чтобы была корректная валидация массива без повторного цикла, переделала soundAll на sound и запустила его в цикле в main

    public static void sound(Animal animal) throws UnknownAnimalException {
        if (animal instanceof Cat) {
            ((Cat) animal).meow();
        } else if (animal instanceof Dog) {
            ((Dog) animal).woof();
        } else if (animal instanceof Cow) {
            ((Cow) animal).moo();
        } else {
            throw new UnknownAnimalException("Unknown animal");
        }
    }
}
