package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
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
        printList(cars);

        Comparator<Car> numComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getNumber().compareTo(o2.getNumber());
            }
        };

        cars.sort(numComparator);
        printList(cars);

        Comparator<Car> yearComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getYear() - o2.getYear();
            }
        };

        cars.sort(yearComparator);
        printList(cars);

        cars.sort(new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        printList(cars);

       cars.sort(numComparator.thenComparing(yearComparator));
       printList(cars);
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("RR-111-XX", "green", 2015));
        cars.add(new Car("RR-222-XX", "red", 2016));
        cars.add(new Car("RR-333-XX", "black", 2017));
        cars.add(new Car("RR-444-XX", "white", 2015));
        cars.add(new Car("RR-555-XX", "red", 2016));
        cars.add(new Car("RR-666-XX", "black", 2017));
        cars.add(new Car("RR-777-XX", "greed", 2015));
        cars.add(new Car("RR-888-XX", "red", 2016));
        cars.add(new Car("RR-999-XX", "white", 2017));
        cars.add(new Car("RR-000-XX", "green", 2015));

        return cars;
    }

    private static void printList(List<?> list) {
        for (var l : list) {
            System.out.println(l);
        }

        System.out.println();
    }

}
