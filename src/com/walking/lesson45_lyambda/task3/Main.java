package com.walking.lesson45_lyambda.task3;

import com.walking.lesson45_lyambda.task3.model.Car;
import com.walking.lesson45_lyambda.task3.service.CarService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarService carService = new CarService(initCars());

        Scanner scanner = new Scanner(System.in);
        boolean execute = true;

        while (execute) {
            System.out.println("Enter query or quit");
            String query = scanner.nextLine();

            if (query.equals("quit")) {
                execute = false;
                continue;
            }

            List<Car> cars = carService.findCars(query);
            if (cars.isEmpty()) {
                System.out.println("No matching cars");
            } else {
                cars.forEach(System.out::println);
            }
        }
        scanner.close();
    }


    private static List<Car> initCars() {
        Car car1 = new Car("RR-111-RR", 2015, "yellow", true);
        Car car2 = new Car("RR-222-RR", 2016, "red", true);
        Car car3 = new Car("RR-333-RR", 2017, "yellow", true);
        Car car4 = new Car("RR-444-RR", 2018, "yellow", true);
        Car car5 = new Car("RR-555-RR", 2018, "black", true);
        Car car6 = new Car("RR-666-RR", 2016, "yellow", true);
        Car car7 = new Car("RR-777-RR", 2018, "red", true);
        Car car8 = new Car("RR-888-RR", 2018, "yellow", true);
        Car car9 = new Car("RR-999-RR", 2018, "yellow", true);
        Car car10 = new Car("RR-000-RR", 2019, "red", true);

        return List.of(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);
    }
}