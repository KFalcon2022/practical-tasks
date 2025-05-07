package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exeptions.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exeptions.UnknownAnimalException;
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
        Animal[] animals = {new Cat(), new Dog(), new Cow()};
            soundAll(animals);
    }

    private static void soundAll (Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                throw new ArrayValidationException(i);
            }
            if (Cat.class.equals(animals[i].getClass())) {
               ((Cat) animals[i]).meow();
            } else if (Cow.class.equals(animals[i].getClass())) {
               ((Cow) animals[i]).moo();
            } else if (Dog.class.equals(animals[i].getClass())) {
               ((Dog) animals[i]).woof();
            } else {
               throw new UnknownAnimalException("Unknown animal");
            }
        }
    }
}
