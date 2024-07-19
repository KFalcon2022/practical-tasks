package com.walking.lesson28_generics1.task2;

import com.walking.lesson28_generics1.task2.model.*;

/**
 * Создать класс-обертку над объектом любого типа.
 * Предусмотреть boolean-метод, проверяющий значение объекта на null.
 */
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{new Cat(), new Dog(), new Cow(), null};

        voiceAll(animals);
    }

    public static void voiceAll(Animal[] animals) {
        AnimalWrapper<Animal> animalWrapper;

        for (Animal animal : animals) {
            animalWrapper = new AnimalWrapper<>(animal);

            if (animalWrapper.isNotNullAnimal()) {
                System.out.println(animalWrapper.getAnimal().sound());
            }
        }
    }
}
