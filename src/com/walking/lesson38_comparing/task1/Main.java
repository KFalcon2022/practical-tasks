package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.comparators.CarColorComparator;
import com.walking.lesson38_comparing.task1.comparators.CarNumberComparator;
import com.walking.lesson38_comparing.task1.comparators.CarYearComparator;
import com.walking.lesson38_comparing.task1.model.Car;
import com.walking.lesson38_comparing.task1.model.CarIdentifier;
import com.walking.lesson38_comparing.task1.service.CarService;

import java.util.List;
import java.util.Scanner;

/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>
 * реализуйте сортировку машин по:
 * · Номеру;
 * · Цвету;
 * · Году;
 * · Номеру и году.
 * <p>
 * Используйте список для хранения и сортировки коллекции машин.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());

        carService.getCars().sort(new CarNumberComparator());

        carService.getCars().sort(new CarColorComparator());

        carService.getCars().sort(new CarYearComparator());

        carService.getCars().sort(new CarYearComparator().thenComparing(new CarNumberComparator()));

        System.out.println(carService.getCars());
    }

    private static List<Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "white", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "green", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2013, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2012, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2011, "yellow", true);

        return List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);
    }
}
