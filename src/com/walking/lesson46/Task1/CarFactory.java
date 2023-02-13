package com.walking.lesson46.Task1;

import java.util.random.RandomGenerator;

public class CarFactory {
    private final static String[] NAMES = {"Вася", "Петя", "Валя", "Галя", "Сережа", "Леша", "Катя", "Света", "Саша"};
    private final static String[] MODELS = {"Lamborgini", "Kalina", "Peugeot", "Volga", "Alfa Romeo"};
    private final static String[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public Car randomCar() {
        return new Car(
                pickRandomCarNumber(LETTERS),
                pickRandomElement(NAMES),
                pickRandomElement(MODELS),
                pickRandomYear());
    }

    private String pickRandomCarNumber(String[] array) {
        return "%s%03d%s%s %02d".formatted(
                pickRandomElement(array),
                nextRandomInt(100),
                pickRandomElement(array),
                pickRandomElement(array),
                nextRandomInt(10));
    }

    private int pickRandomYear() {
        return 2023 - nextRandomInt(30);
    }

    private <T> T pickRandomElement(T[] array) {
        return array[nextRandomInt(array.length)];
    }

    private int nextRandomInt(int range) {
        return RandomGenerator.getDefault().nextInt(range);
    }
}
