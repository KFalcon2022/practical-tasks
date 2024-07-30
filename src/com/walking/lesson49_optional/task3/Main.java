package com.walking.lesson49_optional.task3;

import com.walking.lesson49_optional.task3.model.Animal;
import com.walking.lesson49_optional.task3.model.Cat;
import com.walking.lesson49_optional.task3.model.Cow;
import com.walking.lesson49_optional.task3.model.Dog;

import java.util.Optional;

import static java.util.AbstractMap.*;

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
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null};

        for (Animal animal : animals) {
            printAnimal(animal);

        }
    }

    private static void printAnimal(Animal animal) {
        Optional.ofNullable(animal)
                .filter(x -> x instanceof Cat)
                .map(x -> new SimpleEntry<>("Cat", x.sound()))
                .or(() -> Optional.ofNullable(animal)
                                  .filter(x -> x instanceof Dog)
                                  .map(x -> new SimpleEntry<>("Dog", x.sound())))
                .or(() -> Optional.ofNullable(animal)
                                  .filter(x -> x instanceof Cow)
                                  .map(x -> new SimpleEntry<>("Cow", x.sound())))
                .map(x -> "Это %s, он (она) говорит %s".formatted(x.getKey(), x.getValue()))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Это неизвестное животное"));
    }

    private static void printAnimal1(Animal animal) {
        Optional.ofNullable(animal)
                .map(x -> "Это %s, он (она) говорит %s".formatted(x.getClass()
                                                                   .getSimpleName(), x.sound()))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Это неизвестное животное"));
    }
}
