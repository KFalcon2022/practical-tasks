package com.walking.lesson32_files_1.task2.parser;

import com.walking.lesson32_files_1.task1.model.Car;

import java.util.Arrays;

public class CarParser {
    //TODO валидация данных, ну или таки нет=)
    public static Car[] parseToCar(String parse) {
        String[] cars = parse.split("\n");
        Car[] carsArray = new Car[cars.length];

        for (int i = 0; i < cars.length; i++) {
            String[] split = cars[i].split(",");
            carsArray[i] = new Car(parse(split[0]), parse(split[1]), parse(split[2]), parse(split[3]));
        }

        return carsArray;
    }

    private static String parse(String parse) {
        return parse.split(" = ")[1];
    }
}
