package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.comparator.CarColorComparator;
import com.walking.lesson38_comparing.task1.comparator.CarNumberComparator;
import com.walking.lesson38_comparing.task1.comparator.CarYearComparator;
import com.walking.lesson38_comparing.task1.model.Car;

import java.util.ArrayList;
import java.util.List;

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
        List<Car> cars = initCars();

        CarNumberComparator numberComparator = new CarNumberComparator();
        cars.sort(numberComparator);

        CarColorComparator colorComparator = new CarColorComparator();
        cars.sort(colorComparator);

        CarYearComparator yearComparator = new CarYearComparator();
        cars.sort(yearComparator);

        cars.sort(numberComparator.thenComparing(yearComparator));
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("RR-111-RR", 2015, "yellow", true));
        cars.add(new Car("RR-222-RR", 2016, "yellow", true));
        cars.add(new Car("RR-333-RR", 2017, "black", true));
        cars.add(new Car("RR-444-RR", 2018, "pink", true));
        cars.add(new Car("RR-555-RR", 2018, "green", true));
        cars.add(new Car("RR-666-RR", 2018, "yellow", true));
        cars.add(new Car("RR-777-RR", 2004, "white", true));
        cars.add(new Car("RR-888-RR", 2018, "yellow", true));
        cars.add(new Car("RR-999-RR", 2013, "blue", true));
        cars.add(new Car("RR-000-RR", 2009, "yellow", true));

        return cars;
    }
}
