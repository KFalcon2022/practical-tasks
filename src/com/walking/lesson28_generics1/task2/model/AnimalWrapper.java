package com.walking.lesson28_generics1.task2.model;

public class AnimalWrapper<T extends Animal> {
    private final T animal;

    public AnimalWrapper(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public boolean isNotNullAnimal() {
        return animal != null;
    }
}
