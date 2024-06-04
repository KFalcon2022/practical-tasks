package com.walking.lesson43_map.task2;

import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.service.CarService;

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
        Car car = initCar();

        String foundCar = carService.findCar(car);
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

    private static TreeMap<Integer, Car> initCars() {
        TreeMap<Integer, Car> cars = new TreeMap<>();

        cars.put(1, new Car("RRR-111-XX", 2021, "red", true));
        cars.put(2, new Car("RRR-222-XX", 2020, "red", true));
        cars.put(3, new Car("RRR-333-XX", 2020, "red", true));
        cars.put(4, new Car("RRR-444-XX", 2022, "red", true));
        cars.put(5, new Car("RRR-555-XX", 2020, "red", true));
        cars.put(6, new Car("RRR-666-XX", 2020, "red", true));
        cars.put(7, new Car("RRR-777-XX", 2023, "red", true));
        cars.put(8, new Car("RRR-888-XX", 2020, "red", true));
        cars.put(9, new Car("RRR-999-XX", 2024, "red", true));
        cars.put(10, new Car("RRR-000-XX", 2020, "red", true));

        return cars;
    }
}
