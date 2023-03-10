package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.exception.IncorrectNumberException;
import com.walking.lesson38_comparing.task1.model.Car;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<Car> cars = initCars();

        Comparator<Car> colorComparator = new Comparator<>() {
            @Override
            public int compare(Car firstCar, Car secondCar) {
                return firstCar.getColor().compareTo(secondCar.getColor());
            }
        };

        Comparator<Car> numberComparator = new Comparator<>() {
            @Override
            public int compare(Car firstCar, Car secondCar) {
                return firstCar.getIdentifier().getNumber().compareTo(secondCar.getIdentifier().getNumber());
            }
        };

        Comparator<Car> yearComparator = new Comparator<>() {
            @Override
            public int compare(Car firstCar, Car secondCar) {
                return  firstCar.getIdentifier().getYear() - secondCar.getIdentifier().getYear();
            }
        };

        int number = getSortType();

        switch (number) {
            case (1):
                cars.sort(colorComparator);
                break;

            case (2):
                cars.sort(numberComparator);
                break;

            case (3):
                cars.sort(yearComparator);
                break;

            case (4):
                cars.sort(numberComparator.thenComparing(yearComparator));
                break;

            default:
                throw new IncorrectNumberException("Number entered incorrectly");
        }

        System.out.println(cars);
    }

    private static List<Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "black", true);
        Car car2 = new Car("RR-222-RR", 2016, "white", true);
        Car car3 = new Car("RR-000-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "red", true);
        Car car5 = new Car("RR-555-RR", 2020, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "white", true);
        Car car7 = new Car("RR-777-RR", 2017, "blue", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2019, "black", true);
        Car car10 = new Car("RR-000-RR", 2019, "red", true);

        List<Car> cars = new ArrayList<>(){{
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

    private static int getSortType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sort number:\n" +
                "1. Sort cars by color\n" +
                "2. Sort cars by number\n" +
                "3. Sort cars by year\n" +
                "4. Sort cars by number and year");

        int number = scanner.nextInt();
        scanner.close();

        return number;
    }
}
