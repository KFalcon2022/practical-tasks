package com.walking.lesson32_files_1.task1;

import com.walking.lesson32_files_1.task1.model.Car;
import com.walking.lesson32_files_1.task1.model.Color;
import com.walking.lesson32_files_1.task1.service.CarOutput;

/**
 * Используя класс Car (или создав новый класс для сущности «машина», на ваше усмотрение) из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods/model">...</a>
 * Реализуйте сохранение массива машин в файл carCatalog.txt
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = initCars();
        CarOutput carOutput = new CarOutput(cars);
        carOutput.createCarCatalog();
    }

    private static Car[] initCars() {
        Car car1 = new Car("Obj.292", "XXX-111-RRR", 2015, Color.BLACK);
        Car car2 = new Car("Obj.292", "XXX-222-RRR", 2016, Color.PINK);
        Car car3 = new Car("Obj.292", "XXX-333-RRR", 2017, Color.ORANGE);
        Car car4 = new Car("Obj.292", "XXX-444-RRR", 2018, Color.RED);
        Car car5 = new Car("Obj.292", "XXX-555-RRR", 2019, Color.WHITE);
        Car car6 = new Car("Obj.292", "XXX-666-RRR", 2020, Color.VIOLET);
        Car car7 = new Car("Obj.292", "XXX-777-RRR", 2021, Color.RED);
        Car car8 = new Car("Obj.292", "XXX-888-RRR", 2022, Color.GREEN);
        Car car9 = new Car("Obj.292", "XXX-999-RRR", 2023, Color.WHITE);
        Car car10 = new Car("Obj.292", "XXX-000-RRR", 2024, Color.BLUE);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
