package com.walking.lesson38_comparing.task1;

import com.walking.lesson38_comparing.task1.model.Car;
import com.walking.lesson38_comparing.task1.model.CarIdentifier;
import com.walking.lesson38_comparing.task1.service.CarService;

import java.util.ArrayList;
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
        CarService carService = new CarService(initCars());

        sortCars(carService);

        System.out.println(carService.getCarList());
    }

    public static ArrayList<Car> sortCars(CarService carService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter sort number:\n" +
                "1. Sort cars by color\n" +
                "2. Sort cars by number\n" +
                "3. Sort cars by year\n" +
                "4. Sort cars by number and year");

        int number = scanner.nextInt();
        scanner.close();

        switch (number) {
            case (1):
                return carService.sortByColor();

            case (2):
                return carService.sortByNumber();

            case (3):
                return carService.sortByYear();

            case (4):
                return carService.sortByNumberYear();

            default:
                System.out.println("Number entered incorrectly");
        }

        return null;
    }

    private static ArrayList<Car> initCars() {
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
