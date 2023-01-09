package com.walking.lesson32_files_1.task2.parser;

import com.walking.lesson32_files_1.task1.model.Car;

public class CarParser {
    //TODO валидация данных, ну или таки нет=)
    public static Car parseToCar(String parse) {
        String[] split = parse.split(",");

        return new Car(parse(split[0]), parse(split[1]), parse(split[2]), parse(split[3]));
    }

    private static String parse(String parse) {

        return parse.split("= ")[1];
    }
}
