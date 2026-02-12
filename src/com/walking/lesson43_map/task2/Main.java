package com.walking.lesson43_map.task2;

import com.walking.lesson43_map.task2.model.Car;
import com.walking.lesson43_map.task2.service.CarService;

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

        Car desiredCar = createCar();
        Car foundCar = carService.findCar(desiredCar);

        System.out.println(foundCar);
    }

    private static Car createCar() {
//        Неудачный шаг со сканером, повторно использовать метод createCar() мы не сможем.
//        Спишем на условности
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter a car's number");
//        String number = scanner.nextLine();

        System.out.println("Enter a car's color");
        String color = scanner.nextLine();

        System.out.println("Enter a car's year");
        int year = scanner.nextInt();

        System.out.println("Enter a actuality of technical inspection");
        boolean actualTechnicalInspection = scanner.nextBoolean();

        scanner.close();

        return new Car(year, color, actualTechnicalInspection);
    }

    private static Map<String, Car> initCars() {
        Map<String, Car> carMap = Map.ofEntries(
                Map.entry("RR-111-RR", new Car(2015, "yellow", true)),
                Map.entry("RR-222-RR", new Car(2016, "yellow", true)),
                Map.entry("RR-333-RR", new Car(2017, "yellow", true)),
                Map.entry("RR-444-RR", new Car(2018, "yellow", true)),
                Map.entry("RR-555-RR", new Car(2018, "yellow", true)),
                Map.entry("RR-666-RR", new Car(2018, "yellow", true)),
                Map.entry("RR-777-RR", new Car(2018, "yellow", true)),
                Map.entry("RR-888-RR", new Car(2018, "yellow", true)),
                Map.entry("RR-999-RR", new Car(2018, "yellow", true)),
                Map.entry("RR-000-RR", new Car(2018, "yellow", true))
        );

        return carMap;
    }
}
