package com.walking.lesson43_map.task2;

import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.service.CarService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson19_object_methods">...</a>,
 * используя Map.
 * Реализацию выберите исходя из особенностей исходной задачи.
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());
        Car car = initCar();

        Car foundCar = carService.findCar(car);
        System.out.println(foundCar);
    }

    private static Car initCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number of car: ");
        String number = scanner.nextLine();

        System.out.print("Enter a year of car: ");
        int year = scanner.nextInt();

        scanner.close();

        return new Car(number, year, null, null);
    }

    private static Map<Integer, Car> initCars() {
        Map<Integer, Car> cars = new HashMap<>();

        Car car1 = new Car("RRR-111-XX", 2021, "red", true);
        Car car2 = new Car("RRR-222-XX", 2020, "red", true);
        Car car3 = new Car("RRR-444-XX", 2022, "red", true);
        Car car4 = new Car("RRR-555-XX", 2020, "red", true);
        Car car5 = new Car("RRR-333-XX", 2020, "red", true);
        Car car6 = new Car("RRR-666-XX", 2020, "red", true);
        Car car7 = new Car("RRR-777-XX", 2023, "red", true);
        Car car8 = new Car("RRR-888-XX", 2020, "red", true);
        Car car9 = new Car("RRR-999-XX", 2024, "red", true);
        Car car10 = new Car("RRR-000-XX", 2020, "red", true);

        cars.put(car1.getHashcode(), car1);
        cars.put(car2.getHashcode(), car2);
        cars.put(car3.getHashcode(), car3);
        cars.put(car4.getHashcode(), car4);
        cars.put(car5.getHashcode(), car5);
        cars.put(car6.getHashcode(), car6);
        cars.put(car7.getHashcode(), car7);
        cars.put(car8.getHashcode(), car8);
        cars.put(car9.getHashcode(), car9);
        cars.put(car10.getHashcode(), car10);

        return cars;
    }
}
