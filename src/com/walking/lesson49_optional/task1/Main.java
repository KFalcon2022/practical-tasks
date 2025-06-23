package com.walking.lesson49_optional.task1;

import com.walking.lesson49_optional.task1.model.Car;
import com.walking.lesson49_optional.task1.service.CarService;

import java.util.Optional;
import java.util.Scanner;

/**
 * Реализуйте задачу 2 урока 43:
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson43_map/task2">...</a>
 * тип возвращаемого значения в методе поиска должен быть Optional<Car>.
 * Если ничего не найдено – верните Optional.empty().
 */
public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());

        Car desiredCar = createCar();
        Optional<Car> foundCar = carService.findCar(desiredCar);

        String found = foundCar.map("Найдена машина:\n%s"::formatted)
                               .orElse("Подходящая машина не обнаружена");

        System.out.println(found);
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

    private static Car[] initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "yellow", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "yellow", true);
        Car car6 = new Car("RR-777-RR", 2015, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "yellow", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2018, "yellow", true);

        return new Car[]{car1, car2, car3, car4, car5, car6, car7, car8, car9, car10};
    }
}
