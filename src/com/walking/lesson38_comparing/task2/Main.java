package com.walking.lesson38_comparing.task2;

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
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Honda", "Civic", "1234", 1999));
        cars.add(new Car("BMW", "E46", "4567", 2001));
        cars.add(new Car("Lada", "Vesta", "0967", 2017));
        cars.add(new Car("Nissan", "Almera", "4598", 2015));
        cars.add(new Car("BMW", "E46", "1234", 1998));

        cars.sort(Comparator.naturalOrder());

        printCars(cars);

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println();

        cars.sort(Comparator.reverseOrder());

        printCars(cars);


    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
