package com.walking.lesson46_lambda.task1;

import com.walking.lesson46_lambda.task1.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Реализуйте
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson38_comparing/task1">Задачу 1 из урока 38</a>
 * описывая компараторы как лямбда-выражения.
 */
public class Main {
    public static void main(String[] args) {
        List<Car> cars = createTestCars();

        printList(cars, "Неотсортированные машины:");

        cars.sort(Comparator.comparing(car -> car.getIdentifier()
                                                 .getNumber()));

        printList(cars, "Машины отсортированные по номеру:");

        cars.sort(Comparator.comparingInt(car -> car.getIdentifier()
                                                    .getYear()));

        printList(cars, "Машины отсортированные по году:");

        cars.sort(Comparator.comparing((Car car) -> car.getIdentifier()
                                                       .getNumber())
                            .thenComparingInt((Car car) -> car.getIdentifier()
                                                              .getYear()));

        printList(cars, "Машины отсортированные по номеру и году:");

        cars.sort(Comparator.comparing(Car::getColor));

        printList(cars, "Машины отсортированные по цвету:");

        cars.sort(Car::compareTo);

        printList(cars, "Машины отсортированные по идентификатору в прямом порядке:");

        cars.sort(Comparator.reverseOrder());

        printList(cars, "Машины отсортированные по идентификатору в обратном порядке:");
    }

    public static List<Car> createTestCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("QQQQQQ", 2000, "black", true));
        cars.add(new Car("QQQQQQ", 2024, "white", true));
        cars.add(new Car("QQQQQQ", 1990, "yellow", true));
        cars.add(new Car("FFFFFF", 2024, "green", true));
        cars.add(new Car("FFFFFF", 2000, "yellow", true));
        cars.add(new Car("FFFFFF", 1990, "white", true));
        cars.add(new Car("AAAAAA", 2000, "white", true));
        cars.add(new Car("AAAAAA", 1990, "black", true));
        cars.add(new Car("AAAAAA", 2024, "green", true));

        return cars;
    }

    public static void printList(List<?> elements, String head) {
        System.out.println(head);

        System.out.println("-".repeat(80));

        for (Object element : elements) {
            System.out.println(element);
        }

        System.out.println("-".repeat(80));
    }
}
