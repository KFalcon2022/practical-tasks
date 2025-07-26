package com.walking.lesson38_comparing.task2;

import com.walking.lesson38_comparing.task2.model.Car;

import java.util.Comparator;
import java.util.List;

/**
 * Используя классы-сущности из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson21_immutable_object/model">...</a>,
 * имплементируйте Comparable для Car таким образом,
 * чтобы машины сравнивались по полю identifier.
 * Объекты CarIdentifier предлагаю сравнивать по номеру и году (если номера почему-то совпали).
 * <p>
 * Также реализуйте сортировку коллекции машин в прямом и обратном порядке.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> cars = initCars();

        cars.sort(Comparator.naturalOrder());

        cars.sort(Comparator.reverseOrder());
    }

    private static List<Car> initCars() {
        List<Car> cars = List.of();
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