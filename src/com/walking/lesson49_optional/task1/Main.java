package com.walking.lesson49_optional.task1;

import com.walking.lesson49_optional.task1.model.Car;
import com.walking.lesson49_optional.task1.service.CarService;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods">...</a>,
 * используя Map.
 * Реализацию выберите исходя из особенностей исходной задачи.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());

        Car desiredCar = createCar();
        Optional<Car> foundCar = carService.findCar(desiredCar.getNumber());

        System.out.println(foundCar);
    }

    private static Car createCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's number");
        String number = scanner.nextLine();

        System.out.println("Enter a car's color");
        String color = scanner.nextLine();

        System.out.println("Enter a car's year");
        int year = scanner.nextInt();

        System.out.println("Enter a actuality of technical inspection");
        boolean actualTechnicalInspection = scanner.nextBoolean();

        scanner.close();

        return new Car(number, year, color, actualTechnicalInspection);
    }

    private static Map<String, Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-666-RR", 2018, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        Map<String, Car> cars = new TreeMap<>();

        cars.put(car1.getNumber(), car1);
        cars.put(car2.getNumber(), car2);
        cars.put(car3.getNumber(), car3);
        cars.put(car4.getNumber(), car4);
        cars.put(car5.getNumber(), car5);
        cars.put(car6.getNumber(), car6);
        cars.put(car7.getNumber(), car7);
        cars.put(car8.getNumber(), car8);
        cars.put(car9.getNumber(), car9);
        cars.put(car10.getNumber(), car10);

        return cars;
    }
}
