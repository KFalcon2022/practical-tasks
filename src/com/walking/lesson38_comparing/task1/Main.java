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
        List<Car> cars = getTestCars();

        System.out.println("Неотсортированные машины:");
        printList(cars);

        Comparator<Car> carNumberComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getIdentifier().getNumber().compareTo(o2.getIdentifier().getNumber());
            }
        };

        cars.sort(carNumberComparator);

        System.out.println("Машины отсортированные по номеру:");
        printList(cars);

        Comparator<Car> carYearComparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getIdentifier().getYear() - o2.getIdentifier().getYear();
            }
        };

        cars.sort(carYearComparator);

        System.out.println("Машины отсортированные по году:");
        printList(cars);

        cars.sort(carNumberComparator.thenComparing(carYearComparator));

        System.out.println("Машины отсортированные по номеру и году:");
        printList(cars);

        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        System.out.println("Машины отсортированные по цвету:");
        printList(cars);

        cars.sort(Comparator.naturalOrder());

        System.out.println("Машины отсортированные по идентификатору в прямом порядке:");
        printList(cars);

        cars.sort(Comparator.reverseOrder());

        System.out.println("Машины отсортированные по идентификатору в обратном порядке:");
        printList(cars);
    }

    public static List<Car> getTestCars() {
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

    public static <E> void printList(List<E> elements) {
        System.out.println("-".repeat(80));

        for (E element : elements) {
            System.out.println(element);
        }

        System.out.println("-".repeat(80));
    }
}