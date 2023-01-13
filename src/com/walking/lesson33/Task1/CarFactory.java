package com.walking.lesson33.Task1;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.random.RandomGenerator;
import java.util.List;

public class CarFactory {
    private final static String[] NAMES = {"Вася", "Петя", "Валя", "Галя", "Сережа", "Леша", "Катя", "Света", "Саша"};
    private final static String[] MODELS = {"Lamborgini", "Kalina", "Peugeot", "Volga", "Alfa Romeo"};
    private final static String[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public List<Car> generate(int quantity) {
        return Stream.generate(CarFactory::createRandomCar)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    private static Car createRandomCar(){
        return new Car(
                pickRandomCarNumber(LETTERS),
                pickRandomElement(NAMES),
                pickRandomElement(MODELS));
    }

    private static String pickRandomCarNumber(String[] array){
        return "%s%03d%s%s %02d".formatted(
                pickRandomElement(array),
                nextRandomInt(100),
                pickRandomElement(array),
                pickRandomElement(array),
                nextRandomInt(10));
    }

    private static <T> T pickRandomElement(T[] array){
        return array[nextRandomInt(array.length)];
    }

    private static int nextRandomInt(int range){
        return RandomGenerator.getDefault().nextInt(range);
    }
}
