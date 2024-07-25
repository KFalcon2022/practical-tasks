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
        printList(cars);

        cars.sort(Comparator.naturalOrder());
        printList(cars);

        cars.sort(Comparator.reverseOrder());
        printList(cars);
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("RRR-111-XX", 2011, "green", true));
        cars.add(new Car("RRR-222-XX", 2012, "red", true));
        cars.add(new Car("RRR-333-XX", 2013, "white", true));
        cars.add(new Car("RRR-444-XX", 2014, "red", true));
        cars.add(new Car("RRR-555-XX", 2015, "black", true));
        cars.add(new Car("RRR-666-XX", 2012, "red", true));
        cars.add(new Car("RRR-777-XX", 2013, "red", true));
        cars.add(new Car("RRR-888-XX", 2014, "green", true));
        cars.add(new Car("RRR-999-XX", 2011, "green", true));
        cars.add(new Car("RRR-000-XX", 2010, "black", true));

        return cars;
    }

    private static void printList(List<?> list) {
        for (var l : list) {
            System.out.println(l);
        }

        System.out.println();
    }
}
