package com.walking.lesson20_exceptions.task3;

import com.walking.lesson20_exceptions.task3.exception.ArrayValidationException;
import com.walking.lesson20_exceptions.task3.exception.UnknownAnimalException;
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
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null};

        soundAll(animals);
    }

    private static void soundAll(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                throw new ArrayValidationException(i);
            }

            sound(animals[i]);
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
//            Данное исключение может оказаться полезным, например, если будет реализован и использован
//            наследник Animal, которого забыли добавить в этот метод.
//            Владей мы немного лучше классом Class, можно было бы и указать в сообщении имя класса,
//            объект которого был передан в метод
            throw new UnknownAnimalException("Unknown animal");
        }
    }
}
