package com.walking.lesson38_comparing.task2;

import com.walking.lesson38_comparing.task2.model.Car;

import java.util.ArrayList;
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
        System.out.println(cars);

        cars.sort(Comparator.reverseOrder());
        System.out.println(cars);
    }

    private static ArrayList<Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "black", true);
        Car car2 = new Car("RR-222-RR", 2016, "white", true);
        Car car3 = new Car("RR-000-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-777-RR", 2018, "red", true);
        Car car5 = new Car("RR-555-RR", 2020, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "white", true);
        Car car7 = new Car("RR-777-RR", 2017, "blue", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2019, "black", true);
        Car car10 = new Car("RR-000-RR", 2019, "red", true);

        ArrayList<Car> cars = new ArrayList<>(){{
            add(car1);
            add(car2);
            add(car3);
            add(car4);
            add(car5);
            add(car6);
            add(car7);
            add(car8);
            add(car9);
            add(car10);
        }};

        return cars;
    }
}
