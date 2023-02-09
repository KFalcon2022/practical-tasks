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

        Comparator<Car> numberComparator = new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getIdentifier().getNumber().compareTo(o2.getIdentifier().getNumber());
            }
        };
        cars.sort(numberComparator);
        printList(cars);

        cars.sort(new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        printList(cars);

        Comparator<Car> yearComparator = new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getIdentifier().getYear() - o2.getIdentifier().getYear();
            }
        };
        cars.sort(yearComparator);
        printList(cars);

        cars.sort(numberComparator.thenComparing(yearComparator));
        printList(cars);
    }

    private static List<Car> initCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("RR-111-RR", 2005, "yellow", true));
        cars.add(new Car("RR-111-RR", 2015, "yellow", true));
        cars.add(new Car("RR-222-RR", 2016, "silver", true));
        cars.add(new Car("RR-333-RR", 2017, "blue", true));
        cars.add(new Car("RR-444-RR", 2018, "yellow", true));
        cars.add(new Car("RR-555-RR", 2018, "black", true));
        cars.add(new Car("RR-666-RR", 2018, "yellow", true));
        cars.add(new Car("RR-777-RR", 2020, "yellow", true));
        cars.add(new Car("RR-888-RR", 2018, "green", true));
        cars.add(new Car("RR-999-RR", 2008, "white", true));
        cars.add(new Car("RR-000-RR", 2018, "yellow", true));

        return cars;
    }

    private static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println();
    }
}
