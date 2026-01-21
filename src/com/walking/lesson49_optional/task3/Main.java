package com.walking.lesson49_optional.task3;

import com.walking.lesson49_optional.task3.model.Animal;
import com.walking.lesson49_optional.task3.model.Cat;
import com.walking.lesson49_optional.task3.model.Cow;
import com.walking.lesson49_optional.task3.model.Dog;

import java.util.Map;
import java.util.Optional;

/**
 * Реализуйте абстрактный класс «Животное», содержащий абстрактный метод sound().
 * Также реализуйте трех наследников: кота, собаку и корову.
 * <p>
 * Реализуйте метод, выводящий в консоль сообщение вида
 * <p>
 * «Это %тип животного%, он (она) говорит %результат метода sound()%»
 * Использование условных конструкций (if-else, switch-case, тернарный оператор)
 * и хранение типа наследника в виде поля недопустимо.
 * <p>
 * Подсказка: используйте or().
 */
public class Main {
    public static void main(String[] args) {
        print(new Cow());
        print(new Cat());
        print(null);

    }

    public static void print(Animal animal) {
        Optional.ofNullable(animal)
                .filter(a -> Cat.class.equals(a.getClass()))
                .map(a -> Map.entry("кошка", a))
                .or(() -> Optional.ofNullable(animal)
                        .filter(a -> Dog.class.equals(a.getClass()))
                        .map(a -> Map.entry("собака", a)))
                        .or(() -> Optional.ofNullable(animal).
                                filter(a -> Cow.class.equals(a.getClass()))
                                .map(a -> Map.entry("корова", a)))
                                .ifPresentOrElse(a -> {
                                    System.out.printf("Это %s, она говорит: %s.\n", a.getKey(), a.getValue().sound());
                                }, () -> System.out.println("Животное не найдено."));
    }
}
