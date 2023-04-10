package com.walking.lesson20_exceptions.task3;

/**
 * Реализуйте любой из вариантов задачи в уроке 18.
 * Для ситуации, когда тип животного неизвестен, выбрасывайте собственное исключение UnknownAnimalException.
 * Предка исключения определите самостоятельно.
 * <p>
 * Также предусмотрите валидацию массива животных на содержание пустых элементов.
 * Если таковые существуют – бросьте кастомное исключение ArrayValidationException,
 * которое содержит информацию об индексе массива, содержащем null.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Animal> animalList = new ArrayList<>();
        animalList.add(new Cat());
        animalList.add(new Dog());
        animalList.add(new Cow());

        for (int i=0; i<animalList.size()-1; i++)
        {
            if (animalList.get(i) == null)
                throw new ArrayValidationException("Animal is null", i);
            Speakable.getSound(animalList.get(i));
        }
    }
}