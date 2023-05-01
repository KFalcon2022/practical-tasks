package com.walking.lesson71_thread_safe_collections.task1;

import com.walking.lesson71_thread_safe_collections.task1.model.Car;
import com.walking.lesson71_thread_safe_collections.task1.model.CarIdentifier;
import com.walking.lesson71_thread_safe_collections.task1.service.CarService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Реализуйте Задачу из Урока 61,
 * используя потокобезопасные коллекции вместо механизма synchronized.
 *
 * @see com.walking.lesson61_synchronized.Main
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService();
        initCars(carService);

        CarIdentifier desiredCarIdentifier = createCar();
        Car foundCar = carService.findCar(desiredCarIdentifier);

        System.out.println(foundCar);
    }

    private static CarIdentifier createCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a car's number");
        String number = scanner.nextLine();

        System.out.println("Enter a car's year");
        int year = scanner.nextInt();

        scanner.close();

        return new CarIdentifier(number, year);
    }

    private static void initCars(CarService carService) {
        var cars = new ArrayList<Car>();
        cars.add(new Car("RR-111-RR", 2015, "yellow", true));
        cars.add(new Car("RR-222-RR", 2016, "yellow", true));
        cars.add(new Car("RR-333-RR", 2017, "yellow", true));
        cars.add(new Car("RR-444-RR", 2018, "yellow", true));
        cars.add(new Car("RR-555-RR", 2018, "yellow", true));
        cars.add(new Car("RR-666-RR", 2018, "yellow", true));
        cars.add(new Car("RR-777-RR", 2018, "yellow", true));
        cars.add(new Car("RR-888-RR", 2018, "yellow", true));
        cars.add(new Car("RR-999-RR", 2018, "yellow", true));
        cars.add(new Car("RR-000-RR", 2018, "yellow", true));

        cars.forEach(carService::add);
    }
}